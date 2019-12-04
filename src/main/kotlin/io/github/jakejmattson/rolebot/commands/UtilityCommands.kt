package io.github.jakejmattson.rolebot.commands

import me.aberrantfox.kjdautils.api.dsl.command.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.extensions.stdlib.toMinimalTimeString
import java.awt.Color
import java.util.*

private val startTime = Date()

@CommandSet("Utility")
fun utilityCommands() = commands {
    command("Status", "Ping", "Uptime") {
        description = "Display network status and total uptime."
        execute { event ->
            val jda = event.discord.jda

            jda.restPing.queue { restPing ->
                event.respond {
                    color = Color(0x00bfff)

                    val seconds = (Date().time - startTime.time) / 1000

                    addField("Rest ping", "${restPing}ms")
                    addField("Gateway ping", "${jda.gatewayPing}ms")
                    addField("Total Uptime", seconds.toMinimalTimeString())
                }
            }
        }
    }
}