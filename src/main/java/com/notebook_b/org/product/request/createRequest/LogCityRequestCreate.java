package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogCityRequestCreate {

    private AppEnumCrud crud;

    public LogCityRequestCreate() {
    }

    public LogCityRequestCreate(AppEnumCrud crud) {
        this.crud = crud;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }
}
