package me.jakejmattson.rolebot.commands

import com.gitlab.kordlib.core.behavior.addRole
import com.gitlab.kordlib.core.behavior.edit
import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.discordkt.api.extensions.addField
import me.jakejmattson.rolebot.extensions.toHexString

fun roleEditCommands() = commands("RoleEdit") {
    guildCommand("CreateRole") {
        description = "Create a role with the given name."
        execute(EveryArg) {
            val name = args.first

            guild.addRole {
                this.name = name
            }

            respond("**Role Created**")
        }
    }

    guildCommand("SetName") {
        description = "Set the name of the given role."
        execute(RoleArg, AnyArg) {
            val (role, newName) = args
            val oldName = role.name

            if (oldName == newName) {
                respond("Value already $newName.")
                return@execute
            }

            role.edit {
                this.name = newName
            }

            respond {
                color = role.color
                addField("Role Name Updated", "Role name changed from $oldName to $newName.")
            }
        }
    }

    guildCommand("SetColor") {
        description = "Set the color of the given role."
        execute(RoleArg, HexColorArg) {
            val (role, newColor) = args
            val newColorString = newColor.toHexString()
            val oldColor = role.color.toHexString()

            if (oldColor == newColorString) {
                respond("Value already $newColorString.")
                return@execute
            }

            val changeString = "from $oldColor to $newColorString"

            role.edit {
                this.color = newColor
            }

            respond {
                color = role.color
                addField("Role Color Updated", "Role color changed $changeString.")
            }
        }
    }

    guildCommand("SetMentionable") {
        description = "Set whether or not the given role can be mentioned."
        execute(RoleArg, BooleanArg) {
            val (role, mentionable) = args
            val changeString = "${if (mentionable) "" else "not"} mentionable"

            if (mentionable == role.mentionable) {
                respond("Value already $mentionable.")
                return@execute
            }

            role.edit {
                this.mentionable = mentionable
            }

            respond {
                color = role.color
                addField("Role Mentionability Updated", "Role is now $changeString.")
            }
        }
    }

    guildCommand("DeleteRole") {
        description = "Delete the given role."
        execute(RoleArg) {
            val role = args.first
            role.delete()
            respond("**Role Deleted**")
        }
    }
}