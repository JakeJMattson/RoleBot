package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.command.arguments.RoleArg
import net.dv8tion.jda.core.entities.Role

@CommandSet("Info")
fun infoCommands() = commands {
    command("ViewRole") {
        requiresGuild = true
        description = "View the details of a given role."
        expect(RoleArg)
        execute {
            val role = it.args.component1() as Role

            it.respond(embed {
                setColor(role.color)
                addField("Name", role.name, false)
                addField("Color", role.color.toHexString(), false)
                addField("Mentionable", if (role.isMentionable) "Yes" else "No", false)
            })
        }
    }
}