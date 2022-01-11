package com.notebook_b.org.dto.convertor;

import com.notebook_b.org.dto.entity.PhoneNumberDto;
import com.notebook_b.org.entity.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDtoConvertor {

    public PhoneNumber convert(PhoneNumberDto from) {
        return new PhoneNumber(
                from.getId(),
                from.getPhoneNumber(),
                from.getUserId(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public PhoneNumberDto convert(PhoneNumber from) {
        return new PhoneNumberDto(
                from.getId(),
                from.getPhoneNumber(),
                from.getUserId(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }
}
