# Commands

## Key
| Symbol     | Meaning                    |
| ---------- | -------------------------- |
| (Argument) | This argument is optional. |

## Info
| Commands           | Arguments | Description                          |
| ------------------ | --------- | ------------------------------------ |
| GetMembersWithRole | Role      | View all the members with this role. |
| ViewGuildRoles     | <none>    | View all server roles.               |
| ViewMemberRoles    | User      | View all the roles of a member.      |
| ViewRole           | Role      | View the details of a given role.    |

## RoleEdit
| Commands       | Arguments       | Description                                         |
| -------------- | --------------- | --------------------------------------------------- |
| CreateRole     | Text            | Create a role with the given name.                  |
| DeleteRole     | Role            | Delete the given role.                              |
| SetColor       | Role, Hex Color | Set the color of the given role.                    |
| SetMentionable | Role, Boolean   | Set whether or not the given role can be mentioned. |
| SetName        | Role, Any       | Set the name of the given role.                     |

## RoleGrant
| Commands           | Arguments  | Description                                               |
| ------------------ | ---------- | --------------------------------------------------------- |
| AddGrantable       | Role       | Add a role to the list of roles that can be granted.      |
| Grant              | User, Role | Grant a role to the target user.                          |
| ListGrantableRoles | <none>     | List all roles that can be granted.                       |
| RemoveGrantable    | Role       | Remove a role from the list of roles that can be granted. |
| Revoke             | User, Role | Remove a role from the target user.                       |

## Utility
| Commands             | Arguments | Description                              |
| -------------------- | --------- | ---------------------------------------- |
| Help                 | (Command) | Display a help menu.                     |
| Status, Ping, Uptime | <none>    | Display network status and total uptime. |

