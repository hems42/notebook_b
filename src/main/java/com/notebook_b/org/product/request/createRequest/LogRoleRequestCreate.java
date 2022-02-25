package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogRoleRequestCreate {

    private AppEnumCrud crud;

    private Role role;

    public LogRoleRequestCreate() {
    }

    public LogRoleRequestCreate(AppEnumCrud crud, Role role) {
        this.crud = crud;
        this.role = role;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
