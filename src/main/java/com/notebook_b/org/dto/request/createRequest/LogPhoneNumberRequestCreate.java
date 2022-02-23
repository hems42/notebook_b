package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.entity.PhoneNumber;
import com.notebook_b.org.core.constants.enums.EnumCrud;

public class LogPhoneNumberRequestCreate {

    private EnumCrud crud;

    private PhoneNumber phoneNumber;

    public LogPhoneNumberRequestCreate() {
    }

    public LogPhoneNumberRequestCreate(EnumCrud crud, PhoneNumber phoneNumber) {
        this.crud = crud;
        this.phoneNumber = phoneNumber;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
