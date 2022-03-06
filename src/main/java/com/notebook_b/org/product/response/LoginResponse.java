package com.notebook_b.org.product.response;

import com.notebook_b.org.entity.security.Role;

import java.time.LocalDateTime;
import java.util.Set;

public class LoginResponse {

    private String id;

    private String nickName;

    private String email;

    private Boolean isActive;

    private Boolean isRegistered;

    private Set<Role> roles;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String accessToken;

    private String refreshToken;

    public LoginResponse() {
    }

    public LoginResponse(String id,
                         String nickName,
                         String email,
                         Boolean isActive,
                         Boolean isRegistered,
                         Set<Role> roles,
                         LocalDateTime createdDate,
                         LocalDateTime updatedDate,
                         String accessToken,
                         String refreshToken) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.isActive = isActive;
        this.isRegistered = isRegistered;
        this.roles = roles;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
