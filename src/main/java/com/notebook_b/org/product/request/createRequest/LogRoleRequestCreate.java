package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;

public class LogRoleRequestCreate {

    private AppEnumOperationTypes crud;

    private Role role;

    public LogRoleRequestCreate() {
    }

    public LogRoleRequestCreate(AppEnumOperationTypes crud, Role role) {
        this.crud = crud;
        this.role = role;
    }

    public AppEnumOperationTypes getCrud() {
        return crud;
    }

    public void setCrud(AppEnumOperationTypes crud) {
        this.crud = crud;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
