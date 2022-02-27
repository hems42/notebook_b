package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IAuthenticationController;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnSuccessfulException;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.appEnums.AppEnumUserOperations;
import com.notebook_b.org.product.response.RegistrationResponse;
import com.notebook_b.org.product.security.jwt_security.JwtTokenManager;
import com.notebook_b.org.service.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController implements IAuthenticationController {

    @Autowired
    private JwtTokenManager tokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN), loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/registration")
    public RegistrationResponse confirmUser(@RequestParam String confirmToken) {

        RegistrationResponse registrationResponse = new RegistrationResponse(
          "kullanıcı başarıyla onaylandı",
          "user@user"
        );

        return registrationResponse;

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            UserDto userDto = (UserDto) userService.addLogInLogToUser(loginRequest.getUserNickname()).getData();

            String accessToken = tokenManager.generateToken(loginRequest.getUserNickname());
            return ResponseEntity.ok(new LoginResponse(userDto, accessToken, null));
        } catch (Exception e) {
            throw e;
        }
    }



    @GetMapping("/refreshToken")
    public ResponseEntity<?> refreshToken() {

        throw  new NotFoundException(CoreEnumExceptionMessages.NOT_FOUND_ACCESS_TOKEN,"token yok amına koduum nerde token yavşak");

    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                            loginRequest.getPassword()));
            userService.addLogToUser(new LogUserRequestCreate(AppEnumUserOperations.LOG_IN), loginRequest.getUserNickname());
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUserNickname()));
        } catch (Exception e) {
            System.out.println("gelen hata :" + e.toString());
            throw e;
        }
    }


}
