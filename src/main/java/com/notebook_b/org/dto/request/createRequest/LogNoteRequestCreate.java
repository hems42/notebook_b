package com.notebook_b.org.dto.request.createRequest;

import com.notebook_b.org.entity.Note;
import com.notebook_b.org.entity.enums.EnumCrud;

public class LogNoteRequestCreate {

    private EnumCrud crud;

    public LogNoteRequestCreate() {
    }

    public LogNoteRequestCreate(EnumCrud crud) {
        this.crud = crud;
    }

    public EnumCrud getCrud() {
        return crud;
    }

    public void setCrud(EnumCrud crud) {
        this.crud = crud;
    }
}
