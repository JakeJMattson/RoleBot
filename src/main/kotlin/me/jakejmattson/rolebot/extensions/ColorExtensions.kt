package me.jakejmattson.rolebot.extensions

import java.awt.Color

fun Color.toHexString() = "#%02X%02X%02X".formatArray(intArrayOf(red, green, blue))

private fun String.formatArray(data: IntArray) = String.format(this, data)