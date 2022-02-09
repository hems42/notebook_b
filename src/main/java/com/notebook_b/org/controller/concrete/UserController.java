package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.service.concrete.UserService;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getdeneme")
    public String getDeneme() {
        return "Deneme Başarılı";
    }

    @PostMapping
    public ResponseEntity<DataResult<UserDto>> createUser(
            @Valid @RequestBody UserRequestCreate requestCreate) {
        return ResponseEntity.ok(userService.createUser(requestCreate));
    }

}
