package com.notebook_b.org.product.request.authenticate;

import lombok.ToString;

@ToString
public class LoginRequest {

    private String userNickname;

    private String email;

    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String userNickname, String email, String password) {
        this.userNickname = userNickname;
        this.email = email;
        this.password = password;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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