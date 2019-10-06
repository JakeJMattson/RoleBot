package io.github.jakejmattson.rolebot.commands

import io.github.jakejmattson.rolebot.extensions.toMinimalTimeString
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import java.awt.Color
import java.util.*

private val startTime = Date()

@CommandSet("Utility")
fun utilityCommands() = commands {
    command("Ping") {
        description = "Display network status."
        execute { event ->
            event.discord.jda.restPing.queue {
                event.respond("Ping: ${it}ms\n")
            }
        }
    }

    command("Uptime") {
        requiresGuild = true
        description = "Displays how long the bot has been running."
        execute {
            val seconds = (Date().time - startTime.time) / 1000

            it.respond(embed {
                color = Color.WHITE
                title = "I have been running since"
                description = startTime.toString()

                field {
                    name = "That's been"
                    value = seconds.toMinimalTimeString()
                }
            })
        }
    }
}