package com.notebook_b.org.product.response;

import com.notebook_b.org.product.dto.UserDto;

public class SignUpResponse {

    private AccessTokenResponse accessTokenResponse;

    private RefreshTokenResponse refreshTokenResponse;

    private UserDto user;

    public SignUpResponse() {
    }

    public SignUpResponse(AccessTokenResponse accessTokenResponse,
                          RefreshTokenResponse refreshTokenResponse,
                          UserDto user) {
        this.accessTokenResponse = accessTokenResponse;
        this.refreshTokenResponse = refreshTokenResponse;
        this.user = user;
    }

    public AccessTokenResponse getAccessTokenResponse() {
        return accessTokenResponse;
    }

    public void setAccessTokenResponse(AccessTokenResponse accessTokenResponse) {
        this.accessTokenResponse = accessTokenResponse;
    }

    public RefreshTokenResponse getRefreshTokenResponse() {
        return refreshTokenResponse;
    }

    public void setRefreshTokenResponse(RefreshTokenResponse refreshTokenResponse) {
        this.refreshTokenResponse = refreshTokenResponse;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
