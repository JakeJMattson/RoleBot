package me.jakejmattson.rolebot.services

import me.jakejmattson.discordkt.api.annotations.Service
import net.dv8tion.jda.api.entities.Role

private val grantableRoles = ArrayList<Role>()
fun Role.isGrantable() = grantableRoles.contains(this)

@Service
class RoleGrantingService {
    fun addRole(role: Role) = grantableRoles.add(role)
    fun removeRole(role: Role) = grantableRoles.remove(role)
    fun listRoles() = grantableRoles.joinToString("\n") { it.name }
}