package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.PhoneNumber;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.core.constants.enums.EnumCrud;
import java.time.LocalDateTime;

public class LogPhoneNumberDto {

    private Integer id;

    private EnumCrud crud;

    private PhoneNumber phoneNumber;

    private User user;

    private LocalDateTime createdDate;

    public LogPhoneNumberDto() {
    }

    public LogPhoneNumberDto(
            Integer id,
            EnumCrud crud,
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
