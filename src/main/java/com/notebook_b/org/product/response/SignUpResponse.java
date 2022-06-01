package com.notebook_b.org.product.response;

public class SignUpResponse {

    private String accessToken;

    private String refreshToken;

    private String userId;

    private String nickName;

    private String email;

    private Boolean isActive;

    private Boolean isRegistered;

    public SignUpResponse() {
    }

    public SignUpResponse(String accessToken,
                          String refreshToken,
                          String userId,
                          String nickName,
                          String email,
                          Boolean isActive,
                          Boolean isRegistered) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
        this.isActive = isActive;
        this.isRegistered = isRegistered;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }
}
