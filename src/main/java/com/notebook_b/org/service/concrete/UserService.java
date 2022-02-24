package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.AlReadyExistException;
import com.notebook_b.org.core.exceptions.NotFoundException;
import com.notebook_b.org.product.dto.AddressDto;
import com.notebook_b.org.product.dto.NoteDto;
import com.notebook_b.org.product.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.product.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.product.request.updateRequest.UserRequestUpdate;
import com.notebook_b.org.product.appEnums.AppEnumUserOperations;
import com.notebook_b.org.service.abstracts.ILogUserService;
import com.notebook_b.org.service.abstracts.IUserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.repository.UserDao;
import com.notebook_b.org.product.dto_convertor.entity_convertor.UserDtoConvertor;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.UserRequestCreate;
import com.notebook_b.org.entity.User;
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
        User userDetected = userDao.getUserByNickNameOrEmail(requestCreate.getNickName(), requestCreate.getEmail());

        if (userDetected == null) {
            User user = new User(
                    null,
                    requestCreate.getNickName(),
                    requestCreate.getEmail(),
                    passwordEncoder.encode(requestCreate.getPassword()),
                    true,
                    false,
                    null,
                    LocalDateTime.now(),
                    null
            );

            User userFound = userDao.save(user);
            logUserService.addLogUser(new LogUserRequestCreate(AppEnumUserOperations.CREATED), userFound);
            UserDto userDto = userDtoConvertor.convert(userFound);

            return new SuccessDataResult<>(userDto, "Kullanıcı Başarıyla Eklendi");
        } else {
            throw new AlReadyExistException(requestCreate.getNickName() + " ve  " + requestCreate.getEmail() +
                    " bilgileri verilen kullanıcı daha önce oluşturulmuştur...");
        }

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
        } else {
            throw new NotFoundException(userNickName + " kullanıcı isimli sorgu bulunamadı");
        }

        return new SuccessDataResult<>(userDtoConvertor.convert(user), userNickName + "nickname kullanıcısı başarıyla loglandı " + requestCreate.getUserOperationType().toString());
    }

    @Override
    public DataResult<UserDto> logInUser(String userNickName) {
        return addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN), userNickName);
    }
}
