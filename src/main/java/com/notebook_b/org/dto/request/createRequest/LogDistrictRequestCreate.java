package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.entity.enums.EnumCrud;

public class LogDistrictRequestCreate {

    private EnumCrud crud;

    public LogDistrictRequestCreate() {
    }

    public LogDistrictRequestCreate(EnumCrud crud) {
        this.crud = crud;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }
}
