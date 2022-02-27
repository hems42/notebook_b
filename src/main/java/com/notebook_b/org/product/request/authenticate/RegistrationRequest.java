package com.notebook_b.org.product.request.authenticate;

public class RegistrationRequest {

    private String userNickName;
    private String email;
    private String password;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String userNickName, String email, String password) {
        this.userNickName = userNickName;
        this.email = email;
        this.password = password;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
