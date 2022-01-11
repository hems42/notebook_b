package com.notebook_b.org.dto.entity;


import java.time.LocalDateTime;

public class CityDto {

    private Integer id;

    private String cityName;

    private String plateCode;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public CityDto() {
    }

    public CityDto(
            Integer id,
            String cityName,
            String plateCode,
            LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.cityName = cityName;
        this.plateCode = plateCode;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
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
