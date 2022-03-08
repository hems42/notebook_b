package com.notebook_b.org.product.response;

public class LogOutResponse {

    private Boolean logout;

    public LogOutResponse() {
    }

    public LogOutResponse(Boolean logout) {
        this.logout = logout;
    }

    public Boolean getLogout() {
        return logout;
    }

    public void setLogout(Boolean logout) {
        this.logout = logout;
    }
}
