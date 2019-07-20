# Commands

## Key
| Symbol     | Meaning                    |
| ---------- | -------------------------- |
| (Argument) | This argument is optional. |

## RoleEdit
| Commands       | Arguments        | Description                                         |
| -------------- | ---------------- | --------------------------------------------------- |
| CreateRole     | Text             | Create a role with the given name.                  |
| DeleteRole     | Role             | Delete the given role.                              |
| SetColor       | Role, Hex Colour | Set the color of the given role.                    |
| SetMentionable | Role, Boolean    | Set whether or not the given role can be mentioned. |
| SetName        | Role, Word       | Set the name of the given role.                     |

## Info
| Commands           | Arguments   | Description                          |
| ------------------ | ----------- | ------------------------------------ |
| GetMembersWithRole | Role        | View all the members with this role. |
| ViewGuildRoles     | <none>      | View all server roles.               |
| ViewMemberRoles    | DiscordUser | View all the roles of a member.      |
| ViewRole           | Role        | View the details of a given role.    |

## RoleGrant
| Commands           | Arguments         | Description                                               |
| ------------------ | ----------------- | --------------------------------------------------------- |
| AddGrantable       | Role              | Add a role to the list of roles that can be granted.      |
| Grant              | DiscordUser, Role | Grant a role to the target user.                          |
| ListGrantableRoles | <none>            | List all roles that can be granted.                       |
| RemoveGrantable    | Role              | Remove a role from the list of roles that can be granted. |
| Revoke             | DiscordUser, Role | Remove a role from the target user.                       |

## Utility
| Commands | Arguments | Description                                 |
| -------- | --------- | ------------------------------------------- |
| Ping     | <none>    | Display network status.                     |
| Uptime   | <none>    | Displays how long the bot has been running. |
| help     | (Word)    | Display a help menu                         |

