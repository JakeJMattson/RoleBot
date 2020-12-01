package me.jakejmattson.rolebot.commands

import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.discordkt.api.extensions.addField
import me.jakejmattson.discordkt.api.extensions.toTimeString
import java.util.*
import kotlin.math.roundToInt
import kotlin.time.ExperimentalTime

private val startTime = Date()

@ExperimentalTime
fun utilityCommands() = commands("Utility") {
    guildCommand("Status", "Ping") {
        description = ""
        execute {
            respond {
                val seconds = (Date().time - startTime.time) / 1000

                addField("Gateway Ping", discord.api.gateway.averagePing.inMilliseconds.roundToInt().toString())
                addField("Total Uptime", seconds.toTimeString())
            }
        }
    }
}