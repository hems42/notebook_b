package com.notebook_b.org.product.dto_convertor.principal_convertor;

import com.notebook_b.org.product.dto.NoteDto;
import com.notebook_b.org.entity.aim.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoConvertor {

    public Note convert(NoteDto from) {
        return new Note(
                from.getId(),
                from.getNote(),
                from.getData() == null ? null : from.getData(),
                from.getUserId(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public NoteDto convert(Note from) {
        return new NoteDto(
                from.getId(),
                from.getNote(),
                from.getData() == null ? null : from.getData(),
                from.getUserId(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }
}
