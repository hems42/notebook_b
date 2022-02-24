package com.notebook_b.org.product.request.createRequest;

public class NoteRequestCreate {

    private String note;

    private Byte[] data;

    public NoteRequestCreate() {
    }

    public NoteRequestCreate(String note, Byte[] data) {
        this.note = note;
        this.data = data;
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
}
