package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.arguments.HexColorArg
import io.github.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.command.arguments.RoleArg
import me.aberrantfox.kjdautils.internal.command.arguments.WordArg
import net.dv8tion.jda.core.entities.Role
import java.awt.Color

@CommandSet("RoleEdit")
fun roleEditCommands() = commands {
    command("SetName") {
        requiresGuild = true
        description = "Set the name of the given role."
        expect(RoleArg, WordArg)
        execute {
            val role = it.args.component1() as Role
            val newName = it.args.component2() as String
            val oldName = role.name

            role.manager.setName(newName).queue()

            it.respond(embed {
                setColor(role.color)
                addField("Role Name Updated", "Role name changed from $oldName to $newName", false)
            })
        }
    }

    command("SetColor") {
        requiresGuild = true
        description = "Set the color of the given role."
        expect(RoleArg, HexColorArg)
        execute {
            val role = it.args.component1() as Role
            val newColor = Color(it.args.component2() as Int)
            val oldColor = role.color
            val changeString = "from ${oldColor.toHexString()} to ${newColor.toHexString()}"

            role.manager.setColor(newColor).queue()

            it.respond(embed {
                setColor(role.color)
                addField("Role Color Updated", "Role color changed $changeString", false)
            })
        }
    }
}