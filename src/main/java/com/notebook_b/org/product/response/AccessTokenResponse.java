package com.notebook_b.org.product.response;

public class AccessTokenResponse {

    private String accessToken;

    public AccessTokenResponse() {
    }

    public AccessTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
