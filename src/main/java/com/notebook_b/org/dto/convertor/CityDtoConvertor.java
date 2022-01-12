package com.notebook_b.org.dto.convertor;

import com.notebook_b.org.dto.entity.CityDto;
import com.notebook_b.org.entity.util.City;
import org.springframework.stereotype.Component;

@Component
public class CityDtoConvertor {

    public City convert(CityDto from) {
        return new City(
                from.getId(),
                from.getCityName(),
                from.getPlateCode(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public CityDto convert(City from) {
        return new CityDto(
                from.getId(),
                from.getCityName(),
                from.getPlateCode(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }
}
