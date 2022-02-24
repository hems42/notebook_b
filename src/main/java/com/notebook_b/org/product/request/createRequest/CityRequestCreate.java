package com.notebook_b.org.product.request.createRequest;

public class CityRequestCreate {

    private String cityName;

    private String plateCode;

    public CityRequestCreate() {
    }

    public CityRequestCreate(String cityName, String plateCode) {
        this.cityName = cityName;
        this.plateCode = plateCode;
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
}
