package io.github.jakejmattson.rolebot

import me.aberrantfox.kjdautils.api.startBot

fun main(args: Array<String>) {
    val token = args.firstOrNull()
        ?: throw IllegalArgumentException("No program arguments provided. Expected bot token.")

    startBot(token) {
        configure {
            prefix = "*"
            globalPath = "io.github.jakejmattson.rolebot"
            documentationSortOrder = listOf("RoleEdit", "Info", "RoleGrant", "Utility")
        }
    }
}