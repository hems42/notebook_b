package com.notebook_b.org.product.dto_convertor.log_convertor;

import com.notebook_b.org.product.dto.LogCityDto;
import com.notebook_b.org.entity.log.LogCity;
import org.springframework.stereotype.Component;

@Component
public class LogCityDtoConvertor {

    public LogCity convert(LogCityDto from) {
        return new LogCity(
                from.getId(),
                from.getCrud(),
                from.getCity(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }

    public LogCityDto convert(LogCity from) {
        return new LogCityDto(
                from.getId(),
                from.getCrud(),
                from.getCity(),
                from.getUser(),
                from.getCreatedDate() == null ? null : from.getCreatedDate()
        );
    }
}
