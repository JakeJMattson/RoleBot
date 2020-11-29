package me.jakejmattson.rolebot.commands

import me.jakejmattson.discordkt.api.annotations.CommandSet
import me.jakejmattson.discordkt.api.arguments.RoleArg
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.dsl.command.commands
import me.jakejmattson.discordkt.api.extensions.jda.fullName
import me.jakejmattson.discordkt.api.extensions.jda.toMember
import me.jakejmattson.rolebot.extensions.toHexString

@CommandSet("Info")
fun infoCommands() = commands {
    command("ViewRole") {
        description = "View the details of a given role."
        execute(RoleArg) {
            val role = it.args.first

            it.respond {
                color = role.color
                addField("Name", role.name, false)
                addField("Color", role.color?.toHexString(), false)
                addField("Mentionable", if (role.isMentionable) "Yes" else "No", false)
            }
        }
    }

    command("GetMembersWithRole") {
        description = "View all the members with this role."
        execute(RoleArg) {
            val role = it.args.first
            val members = it.guild!!.members.filter { it.roles.contains(role) }.joinToString("\n") { it.fullName() }

            it.respond("**Members With Role**\n$members")
        }
    }

    command("ViewMemberRoles") {
        description = "View all the roles of a member."
        execute(UserArg) {
            val user = it.args.first
            val roles = user.toMember(it.guild!!)?.roles ?: listOf()
            val roleString = roles.joinToString("\n") { it.name }.takeIf { it.isNotEmpty() } ?: "<No roles>"

            it.respond("**Member Roles**\n$roleString")
        }
    }

    command("ViewGuildRoles") {

        description = "View all server roles."
        execute {
            val roleString = it.guild!!.roles.joinToString("\n") { it.name }
            it.respond("**Server Roles**\n$roleString")
        }
    }
}