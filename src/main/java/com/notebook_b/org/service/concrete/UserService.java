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
import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;
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
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.ALREADY_EXIST_USER;
import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.NOT_FOUND_USER;
import static com.notebook_b.org.product.appEnums.AppEnumOperationTypes.*;

@Slf4j
@Service
public class UserService implements IUserService {

    private final UserDao userDao;
    private final UserDtoConvertor userDtoConvertor;
    private final ILogUserService logUserService;
    private final IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


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

        Role userRole = roleService.getRoleByRoleName(AppEnumRoleTypes.USER).getData();

        HashSet<Role> roles = new HashSet<>();
        roles.add(userRole);

        if (util_isNotExistUserByEmail(requestCreate.getEmail()) &&
                util_isNotExistUserByUserNickName(requestCreate.getNickName())) {
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

            addSignUpLogToUser(null, userFound);

            UserDto userDto = userDtoConvertor.convert(userFound);

            return new SuccessDataResult<>(userDto, "user created successfully");
        } else {
            throw new AlReadyExistException(CoreEnumExceptionMessages.ALREADY_EXIST_USER, "user already created");
        }

    }

    @Override
    public DataResult<UserDto> getUserById(String id) {

        return new SuccessDataResult<UserDto>(userDtoConvertor.convert(util_getUserById(id)),
                "user fetched by ıd");
    }

    @Override
    public DataResult<UserDto> getUserByNickName(String userNickName) {

        User userFound = util_getUserByNickNameOrEmail(userNickName, null);

        UserDto userDto = userDtoConvertor.convert(userFound);

        return new SuccessDataResult<>(userDto, "user fetched by user nick name");
    }

    @Override
    public DataResult<UserDto> getUserByEmail(String email) {

        User userFound = util_getUserByNickNameOrEmail(null, email);

        if (userFound == null) {

            throw new NotFoundException(NOT_FOUND_USER, "cant fetched user by email");
        } else {
            return new SuccessDataResult<>(userDtoConvertor.convert(userFound), "user fetched by email");
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
    public DataResult addLogInLogToUser(@Nullable String userNickName, @Nullable User user) {
        if (userNickName != null) {
            return util_addLogToUser(userNickName, new LogUserRequestCreate(LOG_IN));
        } else {
            return util_addLogToUser(user, new LogUserRequestCreate(LOG_IN));

        }

    }

    @Override
    public DataResult addLogOutLogToUser(@Nullable String userNickName, @Nullable User user) {

        if (userNickName != null) {
            return util_addLogToUser(userNickName, new LogUserRequestCreate(LOG_OUT));
        } else {
            return util_addLogToUser(user, new LogUserRequestCreate(LOG_OUT));

        }
    }

    @Override
    public DataResult addSignUpLogToUser(@Nullable String userNickName, @Nullable User user) {
        if (userNickName != null) {
            return util_addLogToUser(userNickName,
                    new LogUserRequestCreate(AppEnumOperationTypes.CREATED),
                    new LogUserRequestCreate(SIGN_UP),
                    new LogUserRequestCreate(LOG_IN));
        } else {
            return util_addLogToUser(user,
                    new LogUserRequestCreate(AppEnumOperationTypes.CREATED),
                    new LogUserRequestCreate(SIGN_UP),
                    new LogUserRequestCreate(LOG_IN));
        }

    }

    @Override
    public DataResult addRegisteredLogToUser(@Nullable String userNickName, @Nullable User user) {

        if (userNickName != null) {
            return util_addLogToUser(userNickName, new LogUserRequestCreate(REGISTERED));
        } else {
            return util_addLogToUser(user, new LogUserRequestCreate(REGISTERED));

        }
    }

    @Override
    public Boolean setConfirmedUser(User user) {

        user.setIsActive(true);
        user.setUpdatedDate(LocalDateTime.now());
        User userFound = userDao.save(user);
        addRegisteredLogToUser(null, user);

        return userFound != null;
    }


    //****************************************************************//

    //UTIL
    private DataResult util_addLogToUser(User user, LogUserRequestCreate... logUserRequestCreates) {

        if (user != null) {
            for (LogUserRequestCreate logUserRequestCreate : logUserRequestCreates) {
                logUserService
                        .addLogUser(logUserRequestCreate, user);
            }

        } else {
            throw new NotFoundException(NOT_FOUND_USER, "cant add log to user");
        }

        return new SuccessDataResult<>(userDtoConvertor.convert(user),
                user.getNickName() + "log added successfully to user");
    }


    private DataResult util_addLogToUser(String userNickName, LogUserRequestCreate... logUserRequestCreates) {

        User user = userDao.getUserByNickName(userNickName);

        if (user != null) {
            for (LogUserRequestCreate logUserRequestCreate : logUserRequestCreates) {
                logUserService
                        .addLogUser(logUserRequestCreate, user);
            }

        } else {
            throw new NotFoundException(NOT_FOUND_USER, "cant add log to user");
        }

        return new SuccessDataResult<>(userDtoConvertor.convert(user),
                userNickName + "log added successfully to user");
    }

    private User util_getUserById(String userId) {
        User userFound = userDao.getById(userId);

        if (userFound != null) {
            return userFound;
        } else {
            throw new NotFoundException(NOT_FOUND_USER, "user not found by ıd");
        }
    }

    private User util_getUserByNickNameOrEmail(@Nullable String userNickName, @Nullable String email) {
        User userFound;

        if (userNickName != null) {
            userFound = userDao.getUserByNickName(userNickName);

            if (userFound != null) {
                return userFound;
            } else {
                throw new NotFoundException(NOT_FOUND_USER, "not found user by user nick name");
            }

        } else if (email != null) {
            userFound = userDao.getUserByEmail(email);

            if (userFound != null) {
                return userFound;
            } else {
                throw new NotFoundException(NOT_FOUND_USER, "not found user created by email");
            }

        } else if (userNickName != null && email != null) {
            userFound = userDao.getUserByNickNameOrEmail(userNickName, email);

            if (userFound != null) {
                return userFound;
            } else {
                throw new NotFoundException(NOT_FOUND_USER, "not found user by user nick name and  email");
            }
        } else {
            return null;
        }
    }

    private Boolean util_isNotExistUserById(String userId) {

        if (userDao.getById(userId) != null) {
            throw new AlReadyExistException(ALREADY_EXIST_USER, "already exist user by id");
        } else {
            return true;
        }
    }

    private Boolean util_isNotExistUserByEmail(String email) {

        if (userDao.getUserByEmail(email) != null) {
            throw new AlReadyExistException(ALREADY_EXIST_USER, "already exist user by email");
        } else {
            return true;
        }
    }

    private Boolean util_isNotExistUserByUserNickName(String userNickName) {

        if (userDao.getUserByNickName(userNickName) != null) {
            throw new AlReadyExistException(ALREADY_EXIST_USER, "already exist user by nick name");
        } else {
            return true;
        }
    }

//    private Boolean util_isNotExistUserByUserNickNameOrEmail(@Nullable String userId ,
//                                                             @Nullable String userNickName,
//                                                             @Nullable String email)
//    {
//
//    }

}
