package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogAddressDto;
import com.notebook_b.org.entity.log.LogAddress;
import org.springframework.stereotype.Component;

@Component
public class LogAddressDtoConvertor {

    public LogAddress convert(LogAddressDto from) {
        return new LogAddress(
                from.getId(),
                from.getCrud(),
                from.getAddress(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    public LogAddressDto convert(LogAddress from) {
        return new LogAddressDto(
                from.getId(),
                from.getCrud(),
                from.getAddress(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
