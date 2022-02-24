package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogDistrictDto;
import com.notebook_b.org.entity.log.LogDistrict;
import org.springframework.stereotype.Component;

@Component
public class LogDistrictDtoConvertor {

    public LogDistrict convert(LogDistrictDto from) {
        return new LogDistrict(
                from.getId(),
                from.getCrud(),
                from.getCity(),
                from.getDistrict(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()

        );
    }

    public LogDistrictDto convert(LogDistrict from) {
        return new LogDistrictDto(
                from.getId(),
                from.getCrud(),
                from.getCity(),
                from.getDistrict(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
