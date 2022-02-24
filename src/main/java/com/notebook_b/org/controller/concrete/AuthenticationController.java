package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IAuthenticationController;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.appEnums.AppEnumUserOperations;
import com.notebook_b.org.product.security.jwt_security.JwtTokenManager;
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
public class AuthenticationController implements IAuthenticationController {

    @Autowired
    private  JwtTokenManager tokenManager;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  IUserService  userService;




    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
         UserDto userDto =  userService.logInUser(loginRequest.getUserNickname()).getData();

           String accessToken=tokenManager.generateToken(loginRequest.getUserNickname());
            return ResponseEntity.ok(new LoginResponse(userDto,accessToken,null));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN),loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            System.out.println( "gelen hata :" + e.toString());
            throw e;
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN),loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            throw e;
        }
    }
}
