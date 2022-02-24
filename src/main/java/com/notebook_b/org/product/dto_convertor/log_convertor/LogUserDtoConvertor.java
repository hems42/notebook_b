package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogUserDto;
import com.notebook_b.org.entity.log.LogUser;
import org.springframework.stereotype.Component;

@Component
public class LogUserDtoConvertor {

    public LogUser convert(LogUserDto from) {
        return new LogUser(
                from.getId(),
                from.getUserOperationType(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    public LogUserDto convert(LogUser from) {
        return new LogUserDto(
                from.getId(),
                from.getUserOperationType(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
