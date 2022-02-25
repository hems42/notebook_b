package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.communication.Address;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;

import java.time.LocalDateTime;

public class LogAddressDto {

    private Integer id;

    private AppEnumCrud crud;

    private Address address;

    private User user;

    private LocalDateTime createdDate;

    public LogAddressDto() {
    }

    public LogAddressDto(
            Integer id,
            AppEnumCrud crud,
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

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
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
