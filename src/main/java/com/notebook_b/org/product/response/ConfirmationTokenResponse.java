package com.notebook_b.org.product.response;

public class ConfirmationTokenResponse {

    private String confirmationToken;

    public ConfirmationTokenResponse() {
    }

    public ConfirmationTokenResponse(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }
}
