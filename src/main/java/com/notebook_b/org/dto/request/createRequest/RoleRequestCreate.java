package com.notebook_b.org.dto.request.createRequest;

public class RoleRequestCreate {

    private String roleName;

    private String roleDescription;

    public RoleRequestCreate() {
    }

    public RoleRequestCreate(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
