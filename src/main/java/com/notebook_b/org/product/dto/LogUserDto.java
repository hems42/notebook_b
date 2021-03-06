package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;

import java.time.LocalDateTime;

public class LogUserDto {

    private Integer id;

    private AppEnumOperationTypes userOperationType;

    private User user;

    private LocalDateTime createdDate;

    public LogUserDto() {
    }

    public LogUserDto(
            Integer id,
            AppEnumOperationTypes userOperationType,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.userOperationType = userOperationType;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppEnumOperationTypes getUserOperationType() {
        return userOperationType;
    }

    public void setUserOperationType(AppEnumOperationTypes userOperationType) {
        this.userOperationType = userOperationType;
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
