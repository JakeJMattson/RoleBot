package me.jakejmattson.rolebot.extensions

import java.awt.Color

fun Color.toHexString() = "#%02X%02X%02X".format(red, green, blue)