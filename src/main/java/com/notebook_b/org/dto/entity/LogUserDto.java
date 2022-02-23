package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.User;
import com.notebook_b.org.core.constants.enums.EnumUser;

import java.time.LocalDateTime;

public class LogUserDto {

    private Integer id;

    private EnumUser userOperationType;

    private User user;

    private LocalDateTime createdDate;

    public LogUserDto() {
    }

    public LogUserDto(
            Integer id,
            EnumUser userOperationType,
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

    public EnumUser getUserOperationType() {
        return userOperationType;
    }

    public void setUserOperationType(EnumUser userOperationType) {
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
