package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.AddressDto;
import com.notebook_b.org.dto.entity.NoteDto;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.dto.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.dto.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import com.notebook_b.org.dto.request.updateRequest.UserRequestUpdate;

import java.util.List;

public interface IUserService {

    DataResult<UserDto> addUser(UserRequestCreate requestCreate);

    DataResult<List<UserDto>> getAllUsers();

    DataResult<UserDto> updateUserById(String id,UserRequestUpdate requestUpdate);

    DataResult<Boolean> deleteUserById(String id);

    DataResult<UserDto> getUserById(String id);

    DataResult<NoteDto> addNoteToUser(NoteRequestCreate requestCreate);

    DataResult<AddressDto> addAddressToUser(AddressRequestCreate requestCreate);

    DataResult<UserDto> getUserByNickName(String userNickName);

    DataResult addLogToUser(LogUserRequestCreate requestCreate, String userNickName);
}
