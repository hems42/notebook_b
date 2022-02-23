package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IAuthController;
import com.notebook_b.org.dto.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.dto.request.authenticate_request.LoginRequest;
import com.notebook_b.org.core.constants.enums.EnumUser;
import com.notebook_b.org.security.jwt_security.JwtTokenManager;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthController implements IAuthController {

    @Autowired
    private  JwtTokenManager tokenManager;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  IUserService  userService;




    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(EnumUser.LOGIN),loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/api/logout")
    public ResponseEntity<String> logout(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(EnumUser.LOGIN),loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/api/signup")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(EnumUser.LOGIN),loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            throw e;
        }
    }
}
