package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.arguments.HexColorArg
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.command.arguments.RoleArg
import me.aberrantfox.kjdautils.internal.command.arguments.WordArg
import net.dv8tion.jda.core.entities.Role

@CommandSet("RoleEdit")
fun roleEditCommands() = commands {
    command("SetName") {
        requiresGuild = true
        description = "Set the name of the given role."
        expect(RoleArg, WordArg)
        execute {
            val role = it.args.component1() as Role
            val newName = it.args.component2() as String

            role.manager.setName(newName).queue()

            it.respond("Role Name Updated")
        }
    }

    command("SetColor") {
        requiresGuild = true
        description = "Set the color of the given role."
        expect(RoleArg, HexColorArg)
        execute {
            val role = it.args.component1() as Role
            val color = it.args.component2() as Int

            role.manager.setColor(color).queue()

            it.respond(embed {
                setColor(color)
                title("Role Color Updated")
            })
        }
    }
}