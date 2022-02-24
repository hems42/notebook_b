package com.notebook_b.org.controller.abstracts;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.product.dto.AddressDto;
import com.notebook_b.org.product.dto.NoteDto;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.product.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.product.request.createRequest.UserRequestCreate;
import com.notebook_b.org.product.request.updateRequest.UserRequestUpdate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    ResponseEntity<DataResult<UserDto>> addUser(UserRequestCreate requestCreate);

    ResponseEntity<DataResult<List<UserDto>>> getAllUsers();

    ResponseEntity<DataResult<UserDto>> updateUserById(String id, UserRequestUpdate requestUpdate);

    ResponseEntity<DataResult<Boolean>> deleteUserById(String id);

    ResponseEntity<DataResult<UserDto>> getUserById(String id);

    ResponseEntity<DataResult<NoteDto>> addNoteToUser(NoteRequestCreate requestCreate);

    ResponseEntity<DataResult<AddressDto>> addAddressToUser(AddressRequestCreate requestCreate);
}
