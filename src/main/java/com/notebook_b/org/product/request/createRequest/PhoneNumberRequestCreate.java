package com.notebook_b.org.product.request.createRequest;

public class PhoneNumberRequestCreate {

    private String phoneNumber;

    public PhoneNumberRequestCreate() {
    }

    public PhoneNumberRequestCreate(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
