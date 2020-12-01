package me.jakejmattson.rolebot

import com.gitlab.kordlib.gateway.Intents
import me.jakejmattson.discordkt.api.dsl.bot

suspend fun main(args: Array<String>) {
    val token = args.firstOrNull()
        ?: throw IllegalArgumentException("No program arguments provided. Expected bot token.")

    bot(token) {
        prefix { "*" }

        intents {
            Intents.nonPrivileged.intents.forEach {
                +it
            }
        }
    }
}