package io.github.jakejmattson.rolebot

import me.aberrantfox.kjdautils.api.startBot

fun main(args: Array<String>) {
    val token = args.first()

    startBot(token) {
        configure {
            prefix = "*"
            globalPath = "io.github.jakejmattson.rolebot"

            registerInjectionObject(this@startBot.container)
        }
    }
}