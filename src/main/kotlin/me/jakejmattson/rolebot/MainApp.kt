package me.jakejmattson.rolebot

import me.jakejmattson.discordkt.api.dsl.bot

fun main(args: Array<String>) {
    val token = args.firstOrNull()
        ?: throw IllegalArgumentException("No program arguments provided. Expected bot token.")

    bot(token) {
        configure {
            prefix { "*" }
        }
    }
}