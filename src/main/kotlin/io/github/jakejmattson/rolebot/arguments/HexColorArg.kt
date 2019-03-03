package io.github.jakejmattson.rolebot.arguments

import me.aberrantfox.kjdautils.api.dsl.CommandEvent
import me.aberrantfox.kjdautils.internal.command.ArgumentResult
import me.aberrantfox.kjdautils.internal.command.ArgumentType
import me.aberrantfox.kjdautils.internal.command.ConsumptionType

open class HexColorArg(override val name : String = "Hex Colour") : ArgumentType {
    companion object : HexColorArg()

    override val examples = arrayListOf("#000000", "FFFF00", "#3498db", "db3434")
    override val consumptionType = ConsumptionType.Single
    override fun convert(arg: String, args: List<String>, event: CommandEvent): ArgumentResult {
        val error = ArgumentResult.Error("Invalid colour argument.")

        if (arg.length !in 6..7) return error

        val int = try { arg.takeLast(6).toInt(16) } catch (e: NumberFormatException) { return error }

        return if (int >= 0) ArgumentResult.Single(int) else error
    }
}