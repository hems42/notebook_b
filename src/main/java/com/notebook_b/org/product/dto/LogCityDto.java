package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;
import com.notebook_b.org.entity.communication.City;

import java.time.LocalDateTime;

public class LogCityDto {

    private Integer id;

    private AppEnumCrud crud;

    private City city;

    private User user;

    private LocalDateTime createdDate;

    public LogCityDto() {
    }

    public LogCityDto(
            Integer id,
            AppEnumCrud crud,
            City city,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
