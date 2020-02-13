package me.jakejmattson.rolebot.commands

import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.internal.arguments.*

@CommandSet("RoleEdit")
fun roleEditCommands() = commands {
    command("CreateRole") {
        description = "Create a role with the given name."
        execute(SentenceArg) {
            val name = it.args.first

            it.guild!!.createRole().queue {
                it.manager.setName(name).queue()
            }

            it.respond("**Role Created**")
        }
    }

    command("SetName") {
        description = "Set the name of the given role."
        execute(RoleArg, WordArg) {
            val (role, newName) = it.args
            val oldName = role.name

            if (oldName == newName) return@execute it.respond("Value already $newName.")

            role.manager.setName(newName).queue()

            it.respond {
                color = role.color
                addField("Role Name Updated", "Role name changed from $oldName to $newName.", false)
            }
        }
    }

    command("SetColor") {
        description = "Set the color of the given role."
        execute(RoleArg, HexColorArg) {
            val (role, newColor) = it.args
            val newColorString = newColor.toHexString()
            val oldColor = role.color?.toHexString()

            if (oldColor == newColorString) return@execute it.respond("Value already $newColorString.")

            val changeString = "from $oldColor to $newColorString"

            role.manager.setColor(newColor).queue()

            it.respond {
                color = role.color
                addField("Role Color Updated", "Role color changed $changeString.", false)
            }
        }
    }

    command("SetMentionable") {
        description = "Set whether or not the given role can be mentioned."
        execute(RoleArg, BooleanArg) {
            val (role, mentionable) = it.args
            val changeString = "${if (mentionable) "" else "not"} mentionable"

            if (mentionable == role.isMentionable) return@execute it.respond("Value already $mentionable.")

            role.manager.setMentionable(mentionable).queue()

            it.respond {
                color = role.color
                addField("Role Mentionability Updated", "Role is now $changeString.", false)
            }
        }
    }

    command("DeleteRole") {
        description = "Delete the given role."
        execute(RoleArg) {
            val role = it.args.first
            role.delete().queue()
            it.respond("**Role Deleted**")
        }
    }
}