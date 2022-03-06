package com.notebook_b.org.product.response;

public class RefreshTokenResponse {

    private String refreshToken;

    private String accessToken;

    private Boolean isValid;

    private Boolean isChanged;

    public RefreshTokenResponse() {
    }

    public RefreshTokenResponse(String refreshToken,
                                String accessToken,
                                Boolean isValid,
                                Boolean isChanged) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.isValid = isValid;
        this.isChanged = isChanged;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getChanged() {
        return isChanged;
    }

    public void setChanged(Boolean changed) {
        isChanged = changed;
    }
}
