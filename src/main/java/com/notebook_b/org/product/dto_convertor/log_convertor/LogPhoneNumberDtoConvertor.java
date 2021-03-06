package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogPhoneNumberDto;
import com.notebook_b.org.entity.log.LogPhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class LogPhoneNumberDtoConvertor {

    public LogPhoneNumber convert(LogPhoneNumberDto from) {
        return new LogPhoneNumber(
                from.getId(),
                from.getCrud(),
                from.getPhoneNumber(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    public LogPhoneNumberDto convert(LogPhoneNumber from) {
        return new LogPhoneNumberDto(
                from.getId(),
                from.getCrud(),
                from.getPhoneNumber(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
