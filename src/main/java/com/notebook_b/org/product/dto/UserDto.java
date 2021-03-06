package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.security.Role;

import java.time.LocalDateTime;
import java.util.Set;

public class UserDto {

    private String id;

    private String nickName;

    private String email;

    private String password;

    private Boolean isActive;

    private Boolean isRegistered;

    private Set<Role> roles;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public UserDto() {
    }

    public UserDto(
            String id,
            String nickName,
            String email,
            String password,
            Boolean isActive,
            Boolean isRegistered,
            Set<Role> roles, LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.isRegistered = isRegistered;
        this.roles = roles;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", isRegistered=" + isRegistered +
                ", roles=" + roles +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
