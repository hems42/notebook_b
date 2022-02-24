package com.notebook_b.org.product.request.authenticate;
public class LoginRequest {

    private String userNickname;

    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String userNickname, String password) {
        this.userNickname = userNickname;
        this.password = password;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}