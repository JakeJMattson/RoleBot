# Commands

## RoleEdit

| Command        | Arguments       | Effect                                             |
| ------         | ------          | ------                                             |
| CreateRole     | Role Name       | Create a role with the given name.                 |
| SetName        | Role, Word      | Set the name of the given role.                    |
| SetColor       | Role, Hex Color | Set the color of the given role.                   |
| SetMentionable | Role, Boolean   | Set whether or not the given role can be mentioned.|
| DeleteRole     | Role            | Delete the given role.                             |

## Info

| Command            | Arguments | Effect                               |
| ------             | ------    | ------                               |
| ViewRole           | Role      | View the details of a given role.    |
| GetMembersWithRole | Role      | View all the members with this role. |
| ViewMemberRoles    | User      | View all the roles of a member.      |
| ViewGuildRoles     | (none)    | View all server roles.               |

## RoleGrant

| Command            | Arguments  | Effect                                                      |
| ------             | ------     | ------                                                      |
| Grant              | User, Role | Grant a role to the target user.                            |
| Revoke             | User, Role | Remove a role from the target user.                         |
| AddGrantable       | Role       | Add a role to the list of roles that can be granted.        |
| RemoveGrantable    | Role       | Remove a role from the list of roles that can be granted.   |
| ListGrantableRoles | (none)     | List all roles that can be granted.                         |

## Utility

| Command  | Arguments | Effect                               |
| ------   | ------    | ------                               |
| Ping     | (none)    | Display the network ping of the bot. |