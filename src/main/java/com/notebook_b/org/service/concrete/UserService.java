package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.product.appEnums.AppEnumRoleTypes;
import com.notebook_b.org.product.dto.AddressDto;
import com.notebook_b.org.product.dto.NoteDto;
import com.notebook_b.org.product.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.product.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.product.request.updateRequest.UserRequestUpdate;
import com.notebook_b.org.product.appEnums.AppEnumUserOperations;
import com.notebook_b.org.service.abstracts.ILogUserService;
import com.notebook_b.org.service.abstracts.IRoleService;
import com.notebook_b.org.service.abstracts.IUserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.repository.UserDao;
import com.notebook_b.org.product.dto_convertor.principal_convertor.UserDtoConvertor;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.UserRequestCreate;
import com.notebook_b.org.entity.leadRole.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.notebook_b.org.product.appEnums.AppEnumUserOperations.*;

@Slf4j
@Service
public class UserService implements IUserService {

    private final UserDao userDao;
    private final UserDtoConvertor userDtoConvertor;
    private final ILogUserService logUserService;
    private final IRoleService roleService;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;


    public UserService(UserDao userDao,
                       UserDtoConvertor userDtoConvertor,
                       ILogUserService logUserService,
                       RoleService roleService) {
        this.userDao = userDao;
        this.userDtoConvertor = userDtoConvertor;
        this.logUserService = logUserService;
        this.roleService = roleService;
    }

    @Override
    public DataResult<UserDto> addUser(UserRequestCreate requestCreate) {
        User userDetected = userDao.getUserByNickNameOrEmail(
                requestCreate.getNickName(), requestCreate.getEmail());

        Role userRole = roleService.getRoleByRoleName(AppEnumRoleTypes.USER).getData();

        HashSet<Role> roles = new HashSet<>();
        roles.add(userRole);

        if (userDetected == null) {
            User user = new User(
                    null,
                    requestCreate.getNickName(),
                    requestCreate.getEmail(),
                    passwordEncoder.encode(requestCreate.getPassword()),
                    true,
                    false,
                    roles,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );

            User userFound = userDao.save(user);

            addSignUpLogToUser(userFound.getNickName());

            UserDto userDto = userDtoConvertor.convert(userFound);

            return new SuccessDataResult<>(userDto, "user created successfully");
        } else {
            throw new AlReadyExistException(CoreEnumExceptionMessages.ALREADY_EXIST_USER, "user already created");
        }

    }

    @Override
    public DataResult<UserDto> getUserById(String id) {

        return new SuccessDataResult<UserDto>(userDtoConvertor.convert(userDao.getById(id)),
                "user fetched by ıd");
    }

    @Override
    public DataResult<UserDto> getUserByNickName(String userNickName) {

        User userFound = userDao.getUserByNickName(userNickName);

        UserDto userDto = userDtoConvertor.convert(userFound);

        return new SuccessDataResult<>(userDto, "found user by userNickName");
    }

    @Override
    public DataResult<UserDto> getUserByEmail(String email) {

        User userFound = userDao.getUserByEmail(email);

        if (userFound == null) {

            throw new NotFoundException(CoreEnumExceptionMessages.NOT_FOUND_USER,"cant find user by email");
        }
        else
        {
            return new SuccessDataResult<>(userDtoConvertor.convert(userFound),"user fetched by email");
        }
    }

    @Override
    public DataResult<List<UserDto>> getAllUsers() {
        return new SuccessDataResult<List<UserDto>>(userDao.findAll()
                .stream().map(user -> userDtoConvertor.convert(user))
                .collect(Collectors.toList()), "all user fetched successfully");
    }

    @Override
    public DataResult<UserDto> updateUserById(String id, UserRequestUpdate requestUpdate) {

        User foundUser = userDao.findById(id).get();
        foundUser.setEmail(requestUpdate.getEmail());
        foundUser.setPassword(requestUpdate.getPassword());
        foundUser.setNickName(requestUpdate.getNickName());
        foundUser.setUpdatedDate(LocalDateTime.now());

        return new SuccessDataResult<UserDto>(userDtoConvertor.convert(userDao.save(foundUser)),
                "user updated successfully");
    }

    @Override
    public DataResult<Boolean> deleteUserById(String id) {
        User user = userDao.getById(id);
        userDao.delete(user);
        return new SuccessDataResult<Boolean>(true,
                "user deleted");
    }


    @Override
    public DataResult<NoteDto> addNoteToUser(NoteRequestCreate requestCreate) {
        return null;
    }

    @Override
    public DataResult<AddressDto> addAddressToUser(AddressRequestCreate requestCreate) {
        return null;
    }




    //LOG
    @Override
    public DataResult addLogInLogToUser(String userNickName) {
        return addLogToUser(userNickName, new LogUserRequestCreate(LOG_IN));
    }

    @Override
    public DataResult addLogOutLogToUser(String userNickName) {
        return addLogToUser(userNickName, new LogUserRequestCreate(LOG_OUT));
    }

    @Override
    public DataResult addSignUpLogToUser(String userNickName) {
        return addLogToUser(userNickName,
                new LogUserRequestCreate(AppEnumUserOperations.CREATED),
                new LogUserRequestCreate(SIGN_UP),
                new LogUserRequestCreate(LOG_IN));
    }

    @Override
    public DataResult addRegisteredLogToUser(String userNickName) {
        return addLogToUser(userNickName, new LogUserRequestCreate(REGISTERED));
    }

    @Override
    public Boolean setConfirmedUser(User user) {

        user.setIsActive(true);
        user.setUpdatedDate(LocalDateTime.now());
        User userFound = userDao.save(user);
        addRegisteredLogToUser(user.getNickName());

        return userFound!=null;
    }


    //UTIL
    private DataResult addLogToUser(User user,  LogUserRequestCreate... logUserRequestCreates) {

        if (user != null) {
            for (LogUserRequestCreate logUserRequestCreate : logUserRequestCreates) {
                logUserService
                        .addLogUser(logUserRequestCreate, user);
            }

        } else {
            throw new NotFoundException(CoreEnumExceptionMessages.NOT_FOUND_USER, "cant add log to user");
        }

        return new SuccessDataResult<>(userDtoConvertor.convert(user),
                user.getNickName() + "log added successfully to user");
    }


    private DataResult addLogToUser(String userNickName, LogUserRequestCreate... logUserRequestCreates) {

        User user = userDao.getUserByNickName(userNickName);

        if (user != null) {
            for (LogUserRequestCreate logUserRequestCreate : logUserRequestCreates) {
                logUserService
                        .addLogUser(logUserRequestCreate, user);
            }

        } else {
            throw new NotFoundException(CoreEnumExceptionMessages.NOT_FOUND_USER, "cant add log to user");
        }

        return new SuccessDataResult<>(userDtoConvertor.convert(user),
                userNickName + "log added successfully to user");
    }

}
