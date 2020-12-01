package me.jakejmattson.rolebot.services

import com.gitlab.kordlib.core.entity.Role
import me.jakejmattson.discordkt.api.annotations.Service

private val grantableRoles = mutableListOf<Role>()
fun Role.isGrantable() = grantableRoles.contains(this)

@Service
class RoleGrantingService {
    fun addRole(role: Role) = grantableRoles.add(role)
    fun removeRole(role: Role) = grantableRoles.remove(role)
    fun listRoles() = grantableRoles.joinToString("\n") { it.name }
}