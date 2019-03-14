package io.github.jakejmattson.rolebot.commands

import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands

@CommandSet("utility")
fun utilityCommands() = commands {
    command("Ping") {
        description = "Display network status."
        execute {
            it.respond("**Pinged in**: ${it.jda.ping}ms")
        }
    }
}