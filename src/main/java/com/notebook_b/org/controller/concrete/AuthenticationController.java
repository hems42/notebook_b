package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IAuthenticationController;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.RegistrationResponse;
import com.notebook_b.org.product.response.SignUpResponse;
import com.notebook_b.org.service.abstracts.IAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController implements IAuthenticationController {

    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @GetMapping("/registration")
    public RegistrationResponse confirmUser(@RequestParam String confirmToken) {

        return authenticationService.register(confirmToken);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.logIn(loginRequest));
    }


    @GetMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LoginRequest loginRequest) {
/*
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
       //     userService.addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN), loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            System.out.println("gelen hata :" + e.toString());
            throw e;
        }*/

        return ResponseEntity.ok("");
    }


}
