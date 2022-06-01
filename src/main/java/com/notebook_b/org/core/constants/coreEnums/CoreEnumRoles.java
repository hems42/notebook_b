package com.notebook_b.org.core.constants.coreEnums;

public enum CoreEnumRoles {

    ADMIN("ADMIN","0001"),
    SUPER_USER("SUPER_USER","0002"),
    USER("USER","0003"),
    MEMBER("MEMBER","0004");

    private String roleName;
    private String roleCode;

    CoreEnumRoles(String roleName, String roleCode) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }
}
