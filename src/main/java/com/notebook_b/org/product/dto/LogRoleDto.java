package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;

import java.time.LocalDateTime;

public class LogRoleDto {

    private Integer id;

    private AppEnumOperationTypes crud;

    private Role role;

    private User user;

    private LocalDateTime createdDate;

    public LogRoleDto() {
    }

    public LogRoleDto(Integer id,
                      AppEnumOperationTypes crud,
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

    public AppEnumOperationTypes getCrud() {
        return crud;
    }

    public void setCrud(AppEnumOperationTypes crud) {
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
