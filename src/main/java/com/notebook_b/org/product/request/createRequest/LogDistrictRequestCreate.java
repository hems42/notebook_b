package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogDistrictRequestCreate {

    private AppEnumCrud crud;

    public LogDistrictRequestCreate() {
    }

    public LogDistrictRequestCreate(AppEnumCrud crud) {
        this.crud = crud;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }
}
