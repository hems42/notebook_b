package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.core.exceptions.exceptionModel.*;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
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
import com.notebook_b.org.product.response.RegistrationResponse;
import com.notebook_b.org.product.response.SignUpResponse;
import com.notebook_b.org.service.abstracts.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    private final String logTitle = "AuthenticationService ";


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
    public RegistrationResponse register(String confirmationToken) {

        Map<String, String> allErrorMessages = new HashMap<>();
        User userFound = null;
        ConfirmationToken confirmationTokenFound = null;

        try {
            confirmationTokenFound = confirmationTokenService.getConfirmationToken(confirmationToken).get();
        } catch (BaseExceptionModel exceptionModel) {
            if (exceptionModel.getClass() == NotFoundException.class) {
                log.error(logTitle + "confirmation token not found by token");
                allErrorMessages.put(exceptionModel.getErrorCode(), "confirmation token not found");
            }
        }

        try {
            userFound = confirmationTokenFound.getUser();
            if (userFound == null) {
                log.error(logTitle + "user not found by confirmaiton token");
                throw new NotFoundException(NOT_FOUND_USER, "user not found by confirmaiton token");
            }
        } catch (BaseExceptionModel exceptionModel) {
            if (exceptionModel.getClass() == NotFoundException.class) {
                log.error(logTitle + "user not found by token");
                allErrorMessages.put(exceptionModel.getErrorCode(), "user not found by token");
            }
        }

        try {
            confirmationTokenService.verifyConfirmationToken(confirmationTokenFound.getConfirmationToken());
        } catch (BaseExceptionModel exceptionModel) {
            if (exceptionModel.getClass() == AlReadyExistException.class) {
                log.error(logTitle + "user already confirmed");
                allErrorMessages.put(exceptionModel.getErrorCode(), "user already confirmed");
            } else if (exceptionModel.getClass() == NotValidException.class) {
                log.error(logTitle + "confirmation token nat valid, expired");
                allErrorMessages.put(exceptionModel.getErrorCode(), "confirmation token nat valid, expired");
            }
        }


        try {

            if (confirmationTokenService.setConfirmedAt(confirmationTokenFound.getConfirmationToken())) {
                userService.setConfirmedUser(userFound);

                log.info(logTitle + " user confirmed");
                log.info(logTitle + "added to log user registered");
            } else {
                log.error(logTitle + "user not confirmed");

                throw new UnSuccessfulException(UN_SUCCESSFUL_CONFIRMATION_TOKEN_CONFIRMED, "not confirmed user");
            }

        } catch (BaseExceptionModel exceptionModel) {
            if (exceptionModel.getClass() == UnSuccessfulException.class) {
                log.error(logTitle + "unsuccessful performed confirmed user");
                allErrorMessages.put(exceptionModel.getErrorCode(), "unsuccessful performed confirmed user");
            }
        }

        System.out.println("gelen hatalar : "+allErrorMessages);

        if (allErrorMessages.isEmpty()) {
            return new RegistrationResponse(
                    "user registration is succesfully",
                    userFound.getEmail(),
                    userFound.getNickName()
            );
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, allErrorMessages.toString());
        }
    }

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {

        UserDto userDtoFound = null;
        User userFound = null;
        String _accessToken;
        String _refreshToken;

        if (loginRequest.getPassword() != null) {
            if (loginRequest.getUserNickname() != null && loginRequest.getEmail() != null) {

                log.error(logTitle + "just one of username or email options");
                throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                        "just one from username or email options");

            } else if (loginRequest.getUserNickname() != null && loginRequest.getEmail() == null) {

                userDtoFound = userService
                        .getUserByNickName(loginRequest.getUserNickname())
                        .getData();

                userFound = userDtoConvertor
                        .convert(userDtoFound);

            } else if (loginRequest.getUserNickname() == null && loginRequest.getEmail() != null) {
                userDtoFound = userService
                        .getUserByEmail(loginRequest.getEmail())
                        .getData();

                userFound = userDtoConvertor
                        .convert(userDtoFound);
            } else if (loginRequest.getUserNickname() == null && loginRequest.getEmail() == null) {

                log.error(logTitle + "need email or username to login");
                throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                        "need email or username to login");
            }
        } else {
            log.error(logTitle + "need password to login");
            throw new UnAcceptableException(UN_ACCEPTABLE_LOGIN_REQUEST,
                    "need password to login");
        }


        if (userDtoFound != null) {
            if (refreshTokenService.getRefreshTokenByUser(userFound) == null) {

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

                return new LoginResponse(userDtoFound.getId(),
                        userDtoFound.getNickName(),
                        userDtoFound.getEmail(),
                        userDtoFound.getActive(),
                        userDtoFound.getRegistered(),
                        userDtoFound.getRoles(),
                        userDtoFound.getCreatedDate(),
                        userDtoFound.getUpdatedDate(),
                        _accessToken, _refreshToken);

            } else {
                log.error(logTitle + "user already login");
                throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN, "user already login");
            }


        } else {
            log.error(logTitle + "user not found for login");
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
