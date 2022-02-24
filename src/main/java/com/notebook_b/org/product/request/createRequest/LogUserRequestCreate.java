package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumUserOperations;

public class LogUserRequestCreate {

    private AppEnumUserOperations userOperationType;

    public LogUserRequestCreate() {
    }

    public LogUserRequestCreate(AppEnumUserOperations userOperationType) {
        this.userOperationType = userOperationType;
    }

    public AppEnumUserOperations getUserOperationType() {
        return userOperationType;
    }

    public void setUserOperationType(AppEnumUserOperations userOperationType) {
        this.userOperationType = userOperationType;
    }
}
