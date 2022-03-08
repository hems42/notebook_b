package com.notebook_b.org.product.response;

import java.time.LocalDateTime;

public class LogOutResponse {

    private Boolean logout;
    private LocalDateTime timestamp;
    private String refreshToken;

    public LogOutResponse() {
    }

    public LogOutResponse(Boolean logout,
                          LocalDateTime timestamp,
                          String refreshToken) {
        this.logout = logout;
        this.timestamp = timestamp;
        this.refreshToken = refreshToken;
    }

    public Boolean getLogout() {
        return logout;
    }

    public void setLogout(Boolean logout) {
        this.logout = logout;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
