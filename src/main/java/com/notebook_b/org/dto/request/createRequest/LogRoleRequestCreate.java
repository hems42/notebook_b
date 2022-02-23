package com.notebook_b.org.dto.request.createRequest;

public class LogRoleRequestCreate {

    private String roleName;

    private String roleDescription;

    public LogRoleRequestCreate() {
    }

    public LogRoleRequestCreate(String roleName, String roleDescription) {
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
