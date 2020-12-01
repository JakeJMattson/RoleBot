package me.jakejmattson.rolebot.commands

import me.jakejmattson.discordkt.api.arguments.MemberArg
import me.jakejmattson.discordkt.api.arguments.RoleArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.rolebot.services.RoleGrantingService
import me.jakejmattson.rolebot.services.isGrantable

fun roleGrantCommands(roleGrantingService: RoleGrantingService) = commands("RoleGrant") {
    guildCommand("Grant") {
        description = "Grant a role to the target user."
        execute(MemberArg, RoleArg) {
            val (member, role) = args

            if (!role.isGrantable()) {
                respond("Role cannot be granted.")
                return@execute
            }

            member.addRole(role.id)
            respond("`${role.name}` granted to `${member.tag}`.")
        }
    }

    guildCommand("Revoke") {
        description = "Remove a role from the target user."
        execute(MemberArg, RoleArg) {
            val (member, role) = args

            if (!role.isGrantable()) {
                respond("Role cannot be granted (and therefore not revoked).")
                return@execute
            }

            member.removeRole(role.id)
            respond("`${role.name}` revoked from `${member.tag}`.")
        }
    }

    guildCommand("AddGrantable") {
        description = "Add a role to the list of roles that can be granted."
        execute(RoleArg) {
            val role = args.first

            if (role.isGrantable()) {
                respond("Role can already be granted.")
                return@execute
            }

            roleGrantingService.addRole(role)
            respond("`${role.name}` can now be granted.")
        }
    }

    guildCommand("RemoveGrantable") {
        description = "Remove a role from the list of roles that can be granted."
        execute(RoleArg) {
            val role = args.first

            if (!role.isGrantable()) {
                respond("Role cannot be removed - was not grantable.")
                return@execute
            }

            roleGrantingService.removeRole(role)
            respond("`${role.name}` can no longer be granted.")
        }
    }

    guildCommand("ListGrantableRoles") {
        description = "List all roles that can be granted."
        execute {
            respond("**GrantableRoles**\n${roleGrantingService.listRoles()}")
        }
    }
}