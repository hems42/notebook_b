package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.core.constants.enums.EnumCrud;

public class LogCityRequestCreate {

    private EnumCrud crud;

    public LogCityRequestCreate() {
    }

    public LogCityRequestCreate(EnumCrud crud) {
        this.crud = crud;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }
}
