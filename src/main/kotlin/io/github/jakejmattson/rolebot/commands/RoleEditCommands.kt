package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.command.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.arguments.*
import java.awt.Color

@CommandSet("RoleEdit")
fun roleEditCommands() = commands {
    command("CreateRole") {
        requiresGuild = true
        description = "Create a role with the given name."
        execute(SentenceArg) {
            val name = it.args.component1()

            it.guild!!.createRole().queue {
                it.manager.setName(name).queue()
            }

            it.respond("**Role Created**")
        }
    }

    command("SetName") {
        requiresGuild = true
        description = "Set the name of the given role."
        execute(RoleArg, WordArg) {
            val role = it.args.component1()
            val newName = it.args.component2()
            val oldName = role.name

            if (oldName == newName) return@execute it.respond("Value already $newName.")

            role.manager.setName(newName).queue()

            it.respond(embed {
                color = role.color
                addField("Role Name Updated", "Role name changed from $oldName to $newName.", false)
            })
        }
    }

    command("SetColor") {
        requiresGuild = true
        description = "Set the color of the given role."
        execute(RoleArg, HexColorArg) {
            val role = it.args.component1()
            val newColor = Color(it.args.component2())
            val newColorString = newColor.toHexString()
            val oldColor = role.color?.toHexString()

            if (oldColor == newColorString) return@execute it.respond("Value already $newColorString.")

            val changeString = "from $oldColor to $newColorString"

            role.manager.setColor(newColor).queue()

            it.respond(embed {
                color = role.color
                addField("Role Color Updated", "Role color changed $changeString.", false)
            })
        }
    }

    command("SetMentionable") {
        requiresGuild = true
        description = "Set whether or not the given role can be mentioned."
        execute(RoleArg, BooleanArg) {
            val role = it.args.component1()
            val mentionable = it.args.component2()
            val changeString = "${if (mentionable) "" else "not"} mentionable"

            if (mentionable == role.isMentionable) return@execute it.respond("Value already $mentionable.")

            role.manager.setMentionable(mentionable).queue()

            it.respond(embed {
                color = role.color
                addField("Role Mentionability Updated", "Role is now $changeString.", false)
            })
        }
    }

    command("DeleteRole") {
        requiresGuild = true
        description = "Delete the given role."
        execute(RoleArg) {
            val role = it.args.component1()
            role.delete().queue()
            it.respond("**Role Deleted**")
        }
    }
}