package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.UserNotFoundException;
import com.notebook_b.org.dto.entity.AddressDto;
import com.notebook_b.org.dto.entity.NoteDto;
import com.notebook_b.org.dto.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.dto.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.dto.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.dto.request.updateRequest.UserRequestUpdate;
import com.notebook_b.org.entity.enums.EnumCrud;
import com.notebook_b.org.entity.enums.EnumUser;
import com.notebook_b.org.service.abstracts.ILogUserService;
import com.notebook_b.org.service.abstracts.IUserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.repository.UserDao;
import com.notebook_b.org.dto.convertor.UserDtoConvertor;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import com.notebook_b.org.entity.User;
import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final UserDao userDao;
    private final UserDtoConvertor userDtoConvertor;
    private final ILogUserService logUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserService(UserDao userDao,
                       UserDtoConvertor userDtoConvertor,
                       ILogUserService logUserService) {
        this.userDao = userDao;
        this.userDtoConvertor = userDtoConvertor;
        this.logUserService = logUserService;
    }

    @Override
    public DataResult<UserDto> addUser(UserRequestCreate requestCreate) {
        User user = new User(
                null,
                requestCreate.getNickName(),
                requestCreate.getEmail(),
                passwordEncoder.encode(requestCreate.getPassword()),
                true,
                false,
                LocalDateTime.now(),
                null
        );

        User userFound = userDao.save(user);
        logUserService.addLogUser(new LogUserRequestCreate(EnumUser.CREATED),userFound);
        UserDto userDto = userDtoConvertor.convert(userFound);

        return new SuccessDataResult<UserDto>(userDto, "Kullanıcı Başarıyla Eklendi");
    }

    @Override
    public DataResult<List<UserDto>> getAllUsers() {
        return new SuccessDataResult<List<UserDto>>(userDao.findAll()
                .stream().map(user -> userDtoConvertor.convert(user))
                .collect(Collectors.toList()), "Tüm Kullanıcılar Başarıyla Getirildi");
    }

    @Override
    public DataResult<UserDto> updateUserById(String id, UserRequestUpdate requestUpdate) {

        User foundUser = userDao.findById(id).get();
        foundUser.setEmail(requestUpdate.getEmail());
        foundUser.setPassword(requestUpdate.getPassword());
        foundUser.setNickName(requestUpdate.getNickName());
        foundUser.setUpdatedDate(LocalDateTime.now());

        return new SuccessDataResult<UserDto>(userDtoConvertor.convert(userDao.save(foundUser)), "Kullanıcı Başarıyla Güncellendi");
    }

    @Override
    public DataResult<Boolean> deleteUserById(String id) {
        User user = userDao.getById(id);
        userDao.delete(user);
        return new SuccessDataResult<Boolean>(true, "Kullanıcı Başarıyla Silindi");
    }

    @Override
    public DataResult<UserDto> getUserById(String id) {

        return new SuccessDataResult<UserDto>(userDtoConvertor.convert(userDao.getById(id)), "Kullanıcı Başarıyla Getirildi");
    }

    @Override
    public DataResult<NoteDto> addNoteToUser(NoteRequestCreate requestCreate) {
        return null;
    }

    @Override
    public DataResult<AddressDto> addAddressToUser(AddressRequestCreate requestCreate) {
        return null;
    }

    @Override
    public DataResult<UserDto> getUserByNickName(String userNickName) {
        User userFound = userDao.getUserByNickName(userNickName);

        UserDto userDto = userDtoConvertor.convert(userFound);

        return new SuccessDataResult<UserDto>(userDto, "Kullanıcı Başarıyla Bulundu");
    }

    @Override
    public DataResult addLogToUser(LogUserRequestCreate requestCreate, String userNickName) {

        User user = userDao.getUserByNickName(userNickName);

        if (user != null) {
            logUserService.addLogUser(requestCreate, user);
        }
        else {
            throw new UserNotFoundException(userNickName + " kullanıcı isimli sorgu bulunamadı");
        }

        return new SuccessDataResult(userNickName + "nickname kullanıcısı başarıyla loglandı " + requestCreate.getUserOperationType().toString());
    }
}
