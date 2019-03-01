package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.arguments.HexColorArg
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.command.arguments.RoleArg
import net.dv8tion.jda.core.entities.Role

@CommandSet("RoleEdit")
fun roleEditCommands() = commands {
    command("SetColor") {
        requiresGuild = true
        description = "Set the color of the given role."
        expect(RoleArg, HexColorArg)
        execute {
            val role = it.args.component1() as Role
            val color = it.args.component2() as Int

            role.manager.setColor(color).queue()

            it.respond(embed {
                setColor(color)
                title("Role Color Updated")
            })
        }
    }
}