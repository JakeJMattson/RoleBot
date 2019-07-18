package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.extensions.toMinimalTimeString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import java.awt.Color
import java.util.*

private val startTime = Date()

@CommandSet("utility")
fun utilityCommands() = commands {
    command("Ping") {
        description = "Display network status."
        execute {
            it.respond("**Pinged in**: ${it.jda.ping}ms")
        }
    }

    command("Uptime") {
        requiresGuild = true
        description = "Displays how long the bot has been running."
        execute {
            val seconds = (Date().time - startTime.time) / 1000

            it.respond(embed {
                setColor(Color.WHITE)
                setTitle("I have been running since")
                setDescription(startTime.toString())

                field {
                    name = "That's been"
                    value = seconds.toMinimalTimeString()
                }
            })
        }
    }
}