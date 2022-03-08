package com.notebook_b.org.product.appEnums;

public enum AppEnumRoleTypes {
    ADMIN("ADMIN"),
    USER("USER"),
    STUDENT("STUDENT"),
    Admin("Admin");

    public String getRoleName() {
        return roleName;
    }

    ;

    private final String roleName;


    AppEnumRoleTypes(String roleName) {
        this.roleName = roleName;
    }
}