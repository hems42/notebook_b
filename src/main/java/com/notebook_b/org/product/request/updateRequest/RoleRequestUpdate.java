package com.notebook_b.org.product.request.updateRequest;

public class RoleRequestUpdate {

    private String roleName;

    private String roleDescription;

    public RoleRequestUpdate() {
    }

    public RoleRequestUpdate(String roleName, String roleDescription) {
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
