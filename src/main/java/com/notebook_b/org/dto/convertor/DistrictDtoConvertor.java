package com.notebook_b.org.dto.convertor;

import com.notebook_b.org.dto.entity.DistrictDto;
import com.notebook_b.org.entity.util.District;
import org.springframework.stereotype.Component;

@Component
public class DistrictDtoConvertor {

    public District convert(DistrictDto from) {
        return new District(
                from.getId(),
                from.getDistrictName(),
                from.getPostCode(),
                from.getCity(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public DistrictDto convert(District from) {
        return new DistrictDto(
                from.getId(),
                from.getDistrictName(),
                from.getPostCode(),
                from.getCity(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }
}
