package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;

public class LogUserRequestCreate {

    private AppEnumOperationTypes userOperationType;

    public LogUserRequestCreate() {
    }

    public LogUserRequestCreate(AppEnumOperationTypes userOperationType) {
        this.userOperationType = userOperationType;
    }

    public AppEnumOperationTypes getUserOperationType() {
        return userOperationType;
    }

    public void setUserOperationType(AppEnumOperationTypes userOperationType) {
        this.userOperationType = userOperationType;
    }
}
