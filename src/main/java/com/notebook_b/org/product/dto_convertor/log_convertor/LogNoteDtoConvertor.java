package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogNoteDto;
import com.notebook_b.org.entity.log.LogNote;
import org.springframework.stereotype.Component;

@Component
public class LogNoteDtoConvertor {

    public LogNote convert(LogNoteDto from) {
        return new LogNote(
                from.getId(),
                from.getCrud(),
                from.getNote(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    public LogNoteDto convert(LogNote from) {
        return new LogNoteDto(
                from.getId(),
                from.getCrud(),
                from.getNote(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
