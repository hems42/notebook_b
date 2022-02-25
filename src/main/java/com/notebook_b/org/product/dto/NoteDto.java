package com.notebook_b.org.product.dto;

import com.notebook_b.org.entity.leadRole.User;
import java.time.LocalDateTime;

public class NoteDto {

    private Integer id;

    private String note;

    private Byte[] data;

    private User userId;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public NoteDto() {
    }

    public NoteDto(
            Integer id,
            String note,
            Byte[] data,
            User userId,
            LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.note = note;
        this.data = data;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
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
