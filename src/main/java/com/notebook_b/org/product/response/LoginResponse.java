package com.notebook_b.org.product.response;

import com.notebook_b.org.product.dto.UserDto;

public class LoginResponse {

    private UserDto user;

    private String userNickName;



    private String accessToken;

    private String refreshToken;

    public LoginResponse() {
    }

    public LoginResponse(UserDto user, String accessToken, String refreshToken) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
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
}
