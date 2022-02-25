package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.communication.City;
import com.notebook_b.org.entity.communication.District;

import java.time.LocalDateTime;

public class AddressDto {

    private Integer id;

    private String addressDescription;

    private City city;

    private District district;

    private String street;

    private String doorNumberInside;

    private String doorNumberOutside;

    private String addressDetail;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public AddressDto() {
    }

    public AddressDto(
            Integer id,
            String addressDescription,
            City city,
            District district,
            String street,
            String doorNumberInside,
            String doorNumberOutside,
            String addressDetail,
            LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.addressDescription = addressDescription;
        this.city = city;
        this.district = district;
        this.street = street;
        this.doorNumberInside = doorNumberInside;
        this.doorNumberOutside = doorNumberOutside;
        this.addressDetail = addressDetail;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorNumberInside() {
        return doorNumberInside;
    }

    public void setDoorNumberInside(String doorNumberInside) {
        this.doorNumberInside = doorNumberInside;
    }

    public String getDoorNumberOutside() {
        return doorNumberOutside;
    }

    public void setDoorNumberOutside(String doorNumberOutside) {
        this.doorNumberOutside = doorNumberOutside;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
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
