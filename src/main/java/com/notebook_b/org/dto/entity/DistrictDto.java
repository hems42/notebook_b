package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.util.City;

import java.time.LocalDateTime;

public class DistrictDto {

    private Integer id;

    private String districtName;

    private String postCode;

    private City city;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public DistrictDto() {
    }

    public DistrictDto(
            Integer id,
            String districtName,
            String postCode,
            City city,
            LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.districtName = districtName;
        this.postCode = postCode;
        this.city = city;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
