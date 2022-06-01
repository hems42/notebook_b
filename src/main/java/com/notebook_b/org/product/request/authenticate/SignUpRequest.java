package com.notebook_b.org.product.request.authenticate;

    public class SignUpRequest {

        private String userNickName;

    private String eMail;

    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String userNickName, String eMail, String password) {
        this.userNickName = userNickName;
        this.eMail = eMail;
        this.password = password;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
