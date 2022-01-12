package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.entity.enums.EnumUser;

public class LogUserRequestCreate {

    private EnumUser userOperationType;

    public LogUserRequestCreate() {
    }

    public LogUserRequestCreate(EnumUser userOperationType) {
        this.userOperationType = userOperationType;
    }

    public EnumUser getUserOperationType() {
        return userOperationType;
    }

    public void setUserOperationType(EnumUser userOperationType) {
        this.userOperationType = userOperationType;
    }
}
