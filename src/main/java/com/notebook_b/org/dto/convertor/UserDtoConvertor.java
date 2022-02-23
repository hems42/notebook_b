package com.notebook_b.org.dto.convertor;

import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConvertor {

    public User convert(UserDto from) {
        return new User(
                from.getId(),
                from.getNickName(),
                from.getEmail(),
                from.getPassword(),
                from.getActive(),
                from.getRegistered(),
                from.getRoles(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()
        );
    }

    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getNickName(),
                from.getEmail(),
                from.getPassword(),
                from.getIsActive(),
                from.getIsRegistered(),
                from.getRoles(),
                from.getCreatedDate() == null ? null : from.getCreatedDate(),
                from.getUpdatedDate() == null ? null : from.getUpdatedDate()

        );
    }
}
