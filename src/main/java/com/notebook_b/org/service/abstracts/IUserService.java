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

import java.util.List;

public interface IUserService {

    DataResult<UserDto> addUser(UserRequestCreate requestCreate);

    DataResult<UserDto> getUserById(String id);

    DataResult<UserDto> getUserByEmail(String email);

    DataResult<UserDto> getUserByNickName(String userNickName);

    DataResult<List<UserDto>> getAllUsers();

    DataResult<UserDto> updateUserById(String id,UserRequestUpdate requestUpdate);

    DataResult<Boolean> deleteUserById(String id);

    DataResult<NoteDto> addNoteToUser(NoteRequestCreate requestCreate);

    DataResult<AddressDto> addAddressToUser(AddressRequestCreate requestCreate);

    //LOG
    DataResult addLogInLogToUser(String userNickName);

    DataResult addLogOutLogToUser(String userNickName);

    DataResult addSignUpLogToUser(String userNickName);

    DataResult addRegisteredLogToUser(String userNickName);



    Boolean setConfirmedUser(User user);
}
