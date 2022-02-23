package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.Address;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.core.constants.enums.EnumCrud;

import java.time.LocalDateTime;

public class LogAddressDto {

    private Integer id;

    private EnumCrud crud;

    private Address address;

    private User user;

    private LocalDateTime createdDate;

    public LogAddressDto() {
    }

    public LogAddressDto(
            Integer id,
            EnumCrud crud,
            Address address,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
