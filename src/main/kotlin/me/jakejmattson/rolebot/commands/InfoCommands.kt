package me.jakejmattson.rolebot.commands

import kotlinx.coroutines.flow.toList
import me.jakejmattson.discordkt.api.arguments.MemberArg
import me.jakejmattson.discordkt.api.arguments.RoleArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.discordkt.api.extensions.addField
import me.jakejmattson.rolebot.extensions.toHexString

fun infoCommands() = commands("Info") {
    guildCommand("ViewRole") {
        description = "View the details of a given role."
        execute(RoleArg) {
            val role = args.first

            respond {
                color = role.color
                addField("Name", role.name)
                addField("Color", role.color.toHexString())
                addField("Mentionable", if (role.mentionable) "Yes" else "No")
            }
        }
    }

    guildCommand("GetMembersWithRole") {
        description = "View all the members with this role."
        execute(RoleArg) {
            val role = args.first
            val members = guild.members.toList().filter { role in it.roles.toList() }.joinToString("\n") { it.tag }

            respond("**Members With Role**\n$members")
        }
    }

    guildCommand("ViewMemberRoles") {
        description = "View all the roles of a member."
        execute(MemberArg) {
            val member = args.first
            val roles = member.roles.toList()
            val roleString = roles.joinToString("\n") { it.name }.takeIf { it.isNotEmpty() } ?: "<No roles>"

            respond("**Member Roles**\n$roleString")
        }
    }

    guildCommand("ViewGuildRoles") {
        description = "View all server roles."
        execute {
            val roleString = guild.roles.toList().joinToString("\n") { it.name }
            respond("**Server Roles**\n$roleString")
        }
    }
}