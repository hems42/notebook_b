package com.notebook_b.org.dto.entity;

import com.notebook_b.org.entity.Note;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.entity.enums.EnumCrud;

import java.time.LocalDateTime;

public class LogNoteDto {

    private Integer id;

    private EnumCrud crud;

    private Note note;

    private User user;

    private LocalDateTime createdDate;

    public LogNoteDto() {
    }

    public LogNoteDto(
            Integer id,
            EnumCrud crud,
            Note note,
            User user,
            LocalDateTime createdDate) {
        this.id = id;
        this.crud = crud;
        this.note = note;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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
