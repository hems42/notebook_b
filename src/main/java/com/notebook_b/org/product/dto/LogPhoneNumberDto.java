package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.PhoneNumber;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;
import java.time.LocalDateTime;

public class LogPhoneNumberDto {

    private Integer id;

    private AppEnumCrud crud;

    private PhoneNumber phoneNumber;

    private User user;

    private LocalDateTime createdDate;

    public LogPhoneNumberDto() {
    }

    public LogPhoneNumberDto(
            Integer id,
            AppEnumCrud crud,
            PhoneNumber phoneNumber,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
