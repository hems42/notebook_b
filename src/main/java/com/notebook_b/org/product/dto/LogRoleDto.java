package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.Role;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;

import java.time.LocalDateTime;

public class LogRoleDto {

    private Integer id;

    private AppEnumCrud crud;

    private Role role;

    private User user;

    private LocalDateTime createdDate;

    public LogRoleDto() {
    }

    public LogRoleDto(Integer id,
                      AppEnumCrud crud,
                      Role role,
                      User user,
                      LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.role = role;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppEnumCrud getCrud() {
        return crud;
    }

    public void setCrud(AppEnumCrud crud) {
        this.crud = crud;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
