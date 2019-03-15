package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.arguments.RoleArg
import io.github.jakejmattson.rolebot.services.RoleGrantingService
import io.github.jakejmattson.rolebot.services.isGrantable
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.extensions.jda.fullName
import me.aberrantfox.kjdautils.extensions.jda.toMember
import me.aberrantfox.kjdautils.internal.command.arguments.UserArg
import net.dv8tion.jda.core.entities.Role
import net.dv8tion.jda.core.entities.User
import net.dv8tion.jda.core.managers.GuildController

@CommandSet("RoleGrant")
fun roleGrantCommands(roleGrantingService: RoleGrantingService) = commands {

    command("Grant") {
        requiresGuild = true
        description = "Grant a role to the target user."
        expect(UserArg, RoleArg)
        execute {
            val user = it.args.component1() as User
            val role = it.args.component2() as Role

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be granted.")

            val guild = it.guild!!
            GuildController(guild).addSingleRoleToMember(user.toMember(guild), role).queue()

            it.respond("`${role.name}` granted to `${user.fullName()}`.")
        }
    }

    command("Revoke") {
        requiresGuild = true
        description = "Remove a role from the target user."
        expect(UserArg, RoleArg)
        execute {
            val user = it.args.component1() as User
            val role = it.args.component2() as Role

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be granted (and therefore not revoked).")

            val guild = it.guild!!
            GuildController(guild).removeSingleRoleFromMember(user.toMember(guild), role).queue()

            it.respond("`${role.name}` revoked from `${user.fullName()}`.")
        }
    }

    command("AddGrantable") {
        requiresGuild = true
        description = "Add a role to the list of roles that can be granted."
        expect(RoleArg)
        execute {
            val role = it.args.component1() as Role

            if (role.isGrantable())
                return@execute it.respond("Role can already be granted.")

            roleGrantingService.addRole(role)

            it.respond("`${role.name}` can now be granted.")
        }
    }

    command("RemoveGrantable") {
        requiresGuild = true
        description = "Remove a role from the list of roles that can be granted."
        expect(RoleArg)
        execute {
            val role = it.args.component1() as Role

            if (!role.isGrantable())
                return@execute it.respond("Role cannot be removed - was not grantable.")

            roleGrantingService.removeRole(role)

            it.respond("`${role.name}` can no longer be granted.")
        }
    }
}