package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogNoteRequestCreate {

    private AppEnumCrud crud;

    public LogNoteRequestCreate() {
    }

    public LogNoteRequestCreate(AppEnumCrud crud) {
        this.crud = crud;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }
}
