package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.core.exceptions.exceptionModel.UnAcceptableException;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import com.notebook_b.org.product.dto.UserDto;
import com.notebook_b.org.product.dto_convertor.principal_convertor.UserDtoConvertor;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.LogoutRequest;
import com.notebook_b.org.product.request.authenticate.RegistrationRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.request.createRequest.UserRequestCreate;
import com.notebook_b.org.product.response.AccessTokenResponse;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.SignUpResponse;
import com.notebook_b.org.service.abstracts.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.*;
import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.UN_ACCEPTABLE_LOGIN_REQUEST;
import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.UN_SUCCESSFUL_CREATED_REFRESH_TOKEN;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final IUserService userService;
    private final UserDtoConvertor userDtoConvertor;
    private final IRegistrationService registrationService;
    private final IAccessTokenService accessTokenService;
    private final IRefreshTokenService refreshTokenService;
    private final IConfirmationTokenService confirmationTokenService;


    public AuthenticationService(IUserService userService,
                                 UserDtoConvertor userDtoConvertor,
                                 IRegistrationService registrationService,
                                 IAccessTokenService accessTokenService,
                                 IRefreshTokenService refreshTokenService,
                                 IConfirmationTokenService confirmationTokenService) {
        this.userService = userService;
        this.userDtoConvertor = userDtoConvertor;
        this.registrationService = registrationService;
        this.accessTokenService = accessTokenService;
        this.refreshTokenService = refreshTokenService;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signupRequest) {

        UserDto createdUserDto = userService.addUser(
                new UserRequestCreate(signupRequest.getUserNickName(),
                        signupRequest.geteMail(), signupRequest.getPassword())).getData();
        User createdUser = userDtoConvertor.convert(createdUserDto);

        AccessTokenResponse accessTokenResponse = accessTokenService.createAccessTokenWithUserName(
                signupRequest.getUserNickName());

        accessTokenService.authenticateUser(signupRequest.getUserNickName(),
                signupRequest.getPassword());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(createdUser);
        refreshTokenService.saveRefreshToken(refreshToken);

        new Thread(() -> registrationService
                .register(new RegistrationRequest(signupRequest.getUserNickName(),
                                signupRequest.geteMail(),
                                signupRequest.getPassword()),
                        createdUser))
                .start();


        return new SignUpResponse(
                accessTokenResponse.getAccessToken(),
                refreshToken.getRefreshToken(),
                createdUserDto);
    }

    @Override
    public void register() {

    }

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {
        UserDto userFound = null;
        String _accessToken = null;
        String _refreshToken = null;
        HashMap<String, String> allErrors = new HashMap<>();



            if (loginRequest.getUserNickname() != null && loginRequest.getPassword() != null) {
                userFound = userService.getUserByNickName(loginRequest.getUserNickname()).getData();
            } else if (loginRequest.getEmail() != null && loginRequest.getPassword() != null) {
                userFound = userService.getUserByEmail(loginRequest.getEmail()).getData();
            } else {
                throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST, "need email or username and password need to login");
            }


            if (userFound != null) {

                if(refreshTokenService.verifyRefreshToken(userDtoConvertor.convert(userFound)))
                {

                }

                _accessToken = accessTokenService.
                        createAccessTokenWithUserName(userFound.getNickName()).getAccessToken();

                accessTokenService.authenticateUser(userFound.getNickName(),
                        loginRequest.getPassword());

                _refreshToken = refreshTokenService.saveRefreshToken(
                        refreshTokenService.createRefreshToken(userDtoConvertor
                                .convert(userFound)))
                        .get().getRefreshToken();

                userService.addLogInLogToUser(null, userDtoConvertor.convert(userFound));

            }

        return new LoginResponse(userFound, _accessToken, _refreshToken);
    }

    @Override
    public void refreshToken() {

    }

    @Override
    public LogoutRequest logOut(LogoutRequest logoutRequest) {
        return null;
    }
}
