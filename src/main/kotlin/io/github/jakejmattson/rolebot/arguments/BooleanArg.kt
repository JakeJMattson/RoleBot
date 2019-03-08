package io.github.jakejmattson.rolebot.arguments

import me.aberrantfox.kjdautils.api.dsl.CommandEvent
import me.aberrantfox.kjdautils.internal.command.ArgumentResult
import me.aberrantfox.kjdautils.internal.command.ArgumentType
import me.aberrantfox.kjdautils.internal.command.ConsumptionType

open class BooleanArg(override val name: String = "Boolean") : ArgumentType {
    companion object : BooleanArg()

    override val examples = arrayListOf("True", "true", "T")
    override val consumptionType = ConsumptionType.Single
    override fun convert(arg: String, args: List<String>, event: CommandEvent) =
        when (arg.toLowerCase()) {
            "true" -> ArgumentResult.Single(true)
            "t" -> ArgumentResult.Single(true)
            "false" -> ArgumentResult.Single(false)
            "f" -> ArgumentResult.Single(false)
            else -> ArgumentResult.Error("Invalid boolean argument.")
        }
}