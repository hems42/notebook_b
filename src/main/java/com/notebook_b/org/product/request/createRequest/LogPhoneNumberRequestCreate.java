package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.entity.PhoneNumber;
import com.notebook_b.org.product.appEnums.AppEnumCrud;

public class LogPhoneNumberRequestCreate {

    private AppEnumCrud crud;

    private PhoneNumber phoneNumber;

    public LogPhoneNumberRequestCreate() {
    }

    public LogPhoneNumberRequestCreate(AppEnumCrud crud, PhoneNumber phoneNumber) {
        this.crud = crud;
        this.phoneNumber = phoneNumber;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
