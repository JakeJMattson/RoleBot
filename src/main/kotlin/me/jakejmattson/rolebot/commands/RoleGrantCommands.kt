package me.jakejmattson.rolebot.commands

import me.jakejmattson.rolebot.services.RoleGrantingService
import me.jakejmattson.rolebot.services.isGrantable
import me.aberrantfox.kjdautils.api.dsl.command.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.extensions.jda.fullName
import me.aberrantfox.kjdautils.extensions.jda.toMember
import me.aberrantfox.kjdautils.internal.arguments.RoleArg
import me.aberrantfox.kjdautils.internal.arguments.UserArg

@CommandSet("RoleGrant")
fun roleGrantCommands(roleGrantingService: RoleGrantingService) = commands {

    command("Grant") {
        description = "Grant a role to the target user."
        execute(UserArg, RoleArg) {
            val (user, role) = it.args

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be granted.")

            val guild = it.guild!!
            val member = user.toMember(guild)!!
            guild.addRoleToMember(member, role).queue()

            it.respond("`${role.name}` granted to `${user.fullName()}`.")
        }
    }

    command("Revoke") {
        description = "Remove a role from the target user."
        execute(UserArg, RoleArg) {
            val (user, role) = it.args

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be granted (and therefore not revoked).")

            val guild = it.guild!!
            val member = user.toMember(guild)!!
            guild.removeRoleFromMember(member, role).queue()

            it.respond("`${role.name}` revoked from `${user.fullName()}`.")
        }
    }

    command("AddGrantable") {
        description = "Add a role to the list of roles that can be granted."
        execute(RoleArg) {
            val role = it.args.first

            if (role.isGrantable())
                return@execute it.respond("Role can already be granted.")

            roleGrantingService.addRole(role)

            it.respond("`${role.name}` can now be granted.")
        }
    }

    command("RemoveGrantable") {
        description = "Remove a role from the list of roles that can be granted."
        execute(RoleArg) {
            val role = it.args.first

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be removed - was not grantable.")

            roleGrantingService.removeRole(role)

            it.respond("`${role.name}` can no longer be granted.")
        }
    }

    command("ListGrantableRoles") {
        description = "List all roles that can be granted."
        execute {
            it.respond("**GrantableRoles**\n${roleGrantingService.listRoles()}")
        }
    }
}