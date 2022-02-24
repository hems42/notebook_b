package com.notebook_b.org.product.request.createRequest;

import com.notebook_b.org.entity.util.City;
import com.notebook_b.org.entity.util.District;

public class AddressRequestCreate {

    private String addressDescription;

    private City city;

    private District district;

    private String street;

    private String doorNumberInside;

    private String doorNumberOutside;

    private String addressDetail;

    public AddressRequestCreate() {
    }

    public AddressRequestCreate(
            String addressDescription,
            City city,
            District district,
            String street,
            String doorNumberInside,
            String doorNumberOutside,
            String addressDetail) {
        this.addressDescription = addressDescription;
        this.city = city;
        this.district = district;
        this.street = street;
        this.doorNumberInside = doorNumberInside;
        this.doorNumberOutside = doorNumberOutside;
        this.addressDetail = addressDetail;
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
}
