package com.notebook_b.org.dto.request.createRequest;

public class DistrictRequestCreate {

    private String districtName;

    private String postCode;

    public DistrictRequestCreate() {
    }

    public DistrictRequestCreate(String districtName, String postCode) {
        this.districtName = districtName;
        this.postCode = postCode;
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
}
