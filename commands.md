# Commands

## Key 
| Symbol      | Meaning                        |
| ----------- | ------------------------------ |
| (Argument)  | Argument is not required.      |

## Info
| Commands           | Arguments | Description                          |
| ------------------ | --------- | ------------------------------------ |
| GetMembersWithRole | Role      | View all the members with this role. |
| ViewGuildRoles     |           | View all server roles.               |
| ViewMemberRoles    | Member    | View all the roles of a member.      |
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
| Commands           | Arguments    | Description                                               |
| ------------------ | ------------ | --------------------------------------------------------- |
| AddGrantable       | Role         | Add a role to the list of roles that can be granted.      |
| Grant              | Member, Role | Grant a role to the target user.                          |
| ListGrantableRoles |              | List all roles that can be granted.                       |
| RemoveGrantable    | Role         | Remove a role from the list of roles that can be granted. |
| Revoke             | Member, Role | Remove a role from the target user.                       |

## Utility
| Commands     | Arguments | Description          |
| ------------ | --------- | -------------------- |
| Help         | (Command) | Display a help menu. |
| Status, Ping |           |                      |

