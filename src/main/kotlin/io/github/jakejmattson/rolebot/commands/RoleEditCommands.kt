package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.arguments.BooleanArg
import io.github.jakejmattson.rolebot.arguments.HexColorArg
import io.github.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.command.arguments.WordArg
import io.github.jakejmattson.rolebot.arguments.RoleArg
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

            if (oldName == newName) return@execute it.respond("Value already $newName.")

            role.manager.setName(newName).queue()

            it.respond(embed {
                setColor(role.color)
                addField("Role Name Updated", "Role name changed from $oldName to $newName.", false)
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
            val newColorString = newColor.toHexString()
            val oldColor = role.color.toHexString()

            if (oldColor == newColorString) return@execute it.respond("Value already $newColorString.")

            val changeString = "from $oldColor to $newColorString"

            role.manager.setColor(newColor).queue()

            it.respond(embed {
                setColor(role.color)
                addField("Role Color Updated", "Role color changed $changeString.", false)
            })
        }
    }

    command("SetMentionable") {
        requiresGuild = true
        description = "Set whether or not the given role can be mentioned."
        expect(RoleArg, BooleanArg)
        execute {
            val role = it.args.component1() as Role
            val mentionable = it.args.component2() as Boolean
            val changeString = "${if (mentionable) "" else "not"} mentionable"

            if (mentionable == role.isMentionable) return@execute it.respond("Value already $mentionable.")

            role.manager.setMentionable(mentionable).queue()

            it.respond(embed {
                setColor(role.color)
                addField("Role Mentionability Updated", "Role is now $changeString.", false)
            })
        }
    }
}