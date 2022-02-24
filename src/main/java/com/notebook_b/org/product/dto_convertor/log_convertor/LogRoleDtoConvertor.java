package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogRoleDto;
import com.notebook_b.org.entity.log.LogRole;
import org.springframework.stereotype.Component;

@Component
public class LogRoleDtoConvertor {

    LogRole convert(LogRoleDto from) {
        return new LogRole(
                from.getId(),
                from.getCrud(),
                from.getRole(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    LogRoleDto convert(LogRole from) {
        return new LogRoleDto(
                from.getId(),
                from.getCrud(),
                from.getRole(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
