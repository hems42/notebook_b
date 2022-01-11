package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.User;
import com.notebook_b.org.entity.enums.EnumCrud;
import com.notebook_b.org.entity.util.City;
import com.notebook_b.org.entity.util.District;

import java.time.LocalDateTime;

public class LogDistrictDto {

    private Integer id;

    private EnumCrud crud;

    private City city;

    private District district;

    private User user;

    private LocalDateTime createdDate;

    public LogDistrictDto() {
    }

    public LogDistrictDto(
            Integer id,
            EnumCrud crud,
            City city,
            District district,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.city = city;
        this.district = district;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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
