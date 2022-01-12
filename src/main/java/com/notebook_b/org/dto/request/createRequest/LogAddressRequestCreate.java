package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.entity.enums.EnumCrud;

public class LogAddressRequestCreate {

    private EnumCrud crud;

    public LogAddressRequestCreate() {
    }

    public LogAddressRequestCreate(EnumCrud crud) {
        this.crud = crud;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }
}
