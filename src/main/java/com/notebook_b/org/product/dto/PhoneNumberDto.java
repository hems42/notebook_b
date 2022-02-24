package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.User;
import java.time.LocalDateTime;

public class PhoneNumberDto {

    private Integer id;

    private String phoneNumber;

    private User userId;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public PhoneNumberDto() {
    }

    public PhoneNumberDto(
            Integer id,
            String phoneNumber,
            User userId,
            LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
}
