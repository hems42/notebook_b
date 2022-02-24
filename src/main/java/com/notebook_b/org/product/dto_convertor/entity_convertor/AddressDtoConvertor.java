package com.notebook_b.org.product.dto_convertor.entity_convertor;

import com.notebook_b.org.product.dto.AddressDto;
import com.notebook_b.org.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConvertor {

    public Address convert(AddressDto from) {
        return new Address(
                from.getId(),
                from.getAddressDescription(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                from.getDoorNumberInside() == null ? null : from.getDoorNumberInside(),
                from.getDoorNumberOutside() == null ? null : from.getDoorNumberOutside(),
                from.getAddressDetail() == null ? null : from.getAddressDetail(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()

        );
    }

    public AddressDto convert(Address from) {
        return new AddressDto(
                from.getId(),
                from.getAddressDescription(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                from.getDoorNumberInside() == null ? null : from.getDoorNumberInside(),
                from.getDoorNumberOutside() == null ? null : from.getDoorNumberOutside(),
                from.getAddressDetail() == null ? null : from.getAddressDetail(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }
}
