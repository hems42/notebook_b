package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IUserController;
import com.notebook_b.org.dto.entity.AddressDto;
import com.notebook_b.org.dto.entity.NoteDto;
import com.notebook_b.org.dto.request.createRequest.AddressRequestCreate;
import com.notebook_b.org.dto.request.createRequest.NoteRequestCreate;
import com.notebook_b.org.dto.request.updateRequest.UserRequestUpdate;
import com.notebook_b.org.service.concrete.UserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements IUserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    @Override
    public ResponseEntity<DataResult<UserDto>> addUser(UserRequestCreate requestCreate) {
        return ResponseEntity.ok(userService.addUser(requestCreate));
    }

    @GetMapping("/getAllUsers")
    @Override
    public ResponseEntity<DataResult<List<UserDto>>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/updateUserById{id}")
    @Override
    public ResponseEntity<DataResult<UserDto>> updateUserById(@PathVariable String id, UserRequestUpdate requestUpdate) {
        return ResponseEntity.ok(userService.updateUserById(id,requestUpdate));
    }

    @PatchMapping("/deleteUserById{id}")
    @Override
    public ResponseEntity<DataResult<Boolean>> deleteUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @GetMapping("/getUserById{id}")
    @Override
    public ResponseEntity<DataResult<UserDto>> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<DataResult<NoteDto>> addNoteToUser(NoteRequestCreate requestCreate) {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<AddressDto>> addAddressToUser(AddressRequestCreate requestCreate) {
        return null;
    }
}
