package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.dto.AddressDto;
import com.notebook_b.org.product.dto.NoteDto;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.product.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.product.request.createRequest.UserRequestCreate;
import com.notebook_b.org.product.request.updateRequest.UserRequestUpdate;
import org.springframework.lang.Nullable;

import java.util.List;

public interface IUserService {

    UserDto addUser(UserRequestCreate requestCreate);

    UserDto getUserById(String id);

    UserDto getUserByEmail(String email);

    UserDto getUserByNickName(String userNickName);

    List<UserDto> getAllUsers();

    UserDto updateUserById(String id, UserRequestUpdate requestUpdate);

    Boolean deleteUserById(String id);

    DataResult<NoteDto> addNoteToUser(NoteRequestCreate requestCreate);

    DataResult<AddressDto> addAddressToUser(AddressRequestCreate requestCreate);

    //LOG
    DataResult addLogInLogToUser(@Nullable String userNickName, @Nullable User user);

    DataResult addLogOutLogToUser(@Nullable String userNickName, @Nullable User user);

    DataResult addSignUpLogToUser(@Nullable String userNickName, @Nullable User user);

    DataResult addRegisteredLogToUser(@Nullable String userNickName, @Nullable User user);


    Boolean setConfirmedUser(User user);

    Boolean verifyUserPassword(User user, String password);
}
