package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.extensions.toHexString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.extensions.jda.fullName
import me.aberrantfox.kjdautils.extensions.jda.toMember
import me.aberrantfox.kjdautils.internal.arguments.RoleArg
import me.aberrantfox.kjdautils.internal.arguments.UserArg
import net.dv8tion.jda.api.entities.*

@CommandSet("Info")
fun infoCommands() = commands {
    command("ViewRole") {
        requiresGuild = true
        description = "View the details of a given role."
        expect(RoleArg)
        execute {
            val role = it.args.component1() as Role

            it.respond(embed {
                color = role.color
                addField("Name", role.name, false)
                addField("Color", role.color?.toHexString(), false)
                addField("Mentionable", if (role.isMentionable) "Yes" else "No", false)
            })
        }
    }

    command("GetMembersWithRole") {
        requiresGuild = true
        description = "View all the members with this role."
        expect(RoleArg)
        execute {
            val role = it.args.component1() as Role
            val members = it.guild!!.members.filter { it.roles.contains(role) }.joinToString("\n") { it.fullName() }

            it.respond("**Members With Role**\n$members")
        }
    }

    command("ViewMemberRoles") {
        requiresGuild = true
        description = "View all the roles of a member."
        expect(UserArg)
        execute {
            val user = it.args.component1() as User
            val roles = user.toMember(it.guild!!)?.roles ?: listOf()
            val roleString = roles.joinToString("\n") { it.name }.takeIf { it.isNotEmpty() } ?: "<No roles>"

            it.respond("**Member Roles**\n$roleString")
        }
    }

    command("ViewGuildRoles") {
        requiresGuild = true
        description = "View all server roles."
        execute {
            val roleString = it.guild!!.roles.joinToString("\n") { it.name }
            it.respond("**Server Roles**\n$roleString")
        }
    }
}