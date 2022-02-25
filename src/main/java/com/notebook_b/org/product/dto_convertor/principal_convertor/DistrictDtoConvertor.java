package com.notebook_b.org.product.dto_convertor.principal_convertor;

import com.notebook_b.org.product.dto.DistrictDto;
import com.notebook_b.org.entity.communication.District;
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
