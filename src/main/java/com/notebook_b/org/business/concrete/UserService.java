package com.notebook_b.org.business.concrete;

import com.notebook_b.org.business.abstracts.IUserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.dao.UserDao;
import com.notebook_b.org.dto.convertor.UserDtoConvertor;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import com.notebook_b.org.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements IUserService {

    private final UserDao userDao;
    private final UserDtoConvertor userDtoConvertor;

    public UserService(UserDao userDao, UserDtoConvertor userDtoConvertor) {
        this.userDao = userDao;
        this.userDtoConvertor = userDtoConvertor;
    }

    public DataResult<UserDto> createUser(UserRequestCreate requestCreate) {
        User user = new User(
                null,
                requestCreate.getNickName(),
                requestCreate.getEmail(),
                requestCreate.getPassword(),
                true,
                false,
                LocalDateTime.now(),
                null
        );

        User userFound = userDao.save(user);

        UserDto userDto = userDtoConvertor.convert(userFound);

        return new SuccessDataResult<UserDto>(userDto);

    }
}
