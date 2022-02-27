package com.notebook_b.org.product.response;

public class RegistrationResponse {

    private String registryMessage;
    private String email;

    public RegistrationResponse() {
    }

    public RegistrationResponse(String registryMessage, String email) {
        this.registryMessage = registryMessage;
        this.email = email;
    }

    public String getRegistryMessage() {
        return registryMessage;
    }

    public void setRegistryMessage(String registryMessage) {
        this.registryMessage = registryMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
