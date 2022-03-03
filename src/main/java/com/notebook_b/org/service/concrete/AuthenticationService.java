package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;

@Slf4j
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

        UserDto userDtoFound = null;
        User userFound = null;
        String _accessToken = null;
        String _refreshToken = null;

        System.out.println(loginRequest.toString()+" ***********");

                if(loginRequest.getPassword()!=null)
                {
                    if (loginRequest.getUserNickname() != null && loginRequest.getEmail() != null)

                    {

                        throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                                "just one from username or email options");

                    }

                    else if (loginRequest.getUserNickname() != null && loginRequest.getEmail() == null)

                    {

                        userDtoFound = userService
                            .getUserByNickName(loginRequest.getUserNickname())
                            .getData();

                        userFound = userDtoConvertor
                                .convert(userDtoFound);

                    }

                    else if(loginRequest.getUserNickname() == null && loginRequest.getEmail() != null)
                    {
                        userDtoFound = userService
                                .getUserByEmail(loginRequest.getEmail())
                                .getData();

                        userFound = userDtoConvertor
                                .convert(userDtoFound);
                    }
                    else if(loginRequest.getUserNickname() == null && loginRequest.getEmail() == null)
                    {
                        throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                                "need email or username to login");
                    }
                }
                else
                {
                    throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                            "need password to login");
                }


        if (userDtoFound != null && refreshTokenService.getRefreshTokenByUser(userFound) == null) {

            if (refreshTokenService.verifyRefreshToken(userDtoConvertor.convert(userDtoFound))) {
                _accessToken = accessTokenService
                        .createAccessTokenWithUserName(userDtoFound.getNickName())
                        .getAccessToken();

                accessTokenService
                        .authenticateUser(
                                userDtoFound.getNickName(),
                                loginRequest.getPassword()
                        );

                _refreshToken = refreshTokenService
                        .saveRefreshToken(refreshTokenService
                                .createRefreshToken(userFound))
                        .get().getRefreshToken();

                userService.addLogInLogToUser(null, userFound);

                return new LoginResponse(userDtoFound, _accessToken, _refreshToken);
            } else {
                throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN, "user already login");
            }
        } else {
            throw new NotFoundException(NOT_FOUND_USER, "user not found for login");
        }
    }

    @Override
    public void refreshToken() {

    }

    @Override
    public LogoutRequest logOut(LogoutRequest logoutRequest) {
        return null;
    }
}
