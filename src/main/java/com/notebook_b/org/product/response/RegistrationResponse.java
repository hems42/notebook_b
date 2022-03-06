package com.notebook_b.org.product.response;

public class RegistrationResponse {

    private String registryMessage;
    private String email;
    private String userNickName;

    public RegistrationResponse() {
    }

    public RegistrationResponse(String registryMessage,
                                String email,
                                String userNickName) {
        this.registryMessage = registryMessage;
        this.email = email;
        this.userNickName = userNickName;
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

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
}
