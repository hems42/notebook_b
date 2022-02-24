package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogAddressRequestCreate {

    private AppEnumCrud crud;

    public LogAddressRequestCreate() {
    }

    public LogAddressRequestCreate(AppEnumCrud crud) {
        this.crud = crud;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }
}
