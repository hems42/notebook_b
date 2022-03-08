package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnAcceptableException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnSuccessfulException;
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
import com.notebook_b.org.product.response.*;
import com.notebook_b.org.service.abstracts.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.*;
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

    private final String logTitle = "AuthenticationService : -> ";


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

        UserDto userDtoCreated;
        User userCreated;
        RefreshToken refreshTokenCreated;

        try {
            userDtoCreated = userService.addUser(
                    new UserRequestCreate(signupRequest.getUserNickName(),
                            signupRequest.geteMail(), signupRequest.getPassword())).getData();
            userCreated = userDtoConvertor.convert(userDtoCreated);

            AccessTokenResponse accessTokenResponse = accessTokenService.createAccessTokenWithUserName(
                    signupRequest.getUserNickName());

            accessTokenService.authenticateUser(signupRequest.getUserNickName(),
                    signupRequest.getPassword());

            refreshTokenCreated = refreshTokenService.createRefreshToken(userCreated);
            refreshTokenService.saveRefreshToken(refreshTokenCreated);

            new Thread(() -> registrationService
                    .register(
                            new RegistrationRequest(
                                    signupRequest.getUserNickName(),
                                    signupRequest.geteMail(),
                                    signupRequest.getPassword()),
                            userCreated
                    )).start();

            log.info(logTitle + "user created successfully");

            return new SignUpResponse(
                    accessTokenResponse.getAccessToken(),
                    refreshTokenCreated.getRefreshToken(),
                    userDtoCreated);
        } catch (BaseExceptionModel exceptionModel) {
            log.error(logTitle + "user not not created: " + exceptionModel.getErrorDescription());

            throw new UnSuccessfulException(UN_SUCCESSFUL_USER_CREATE,
                    exceptionModel.getErrorCode() + " : " + exceptionModel.getErrorDescription());
        }

    }

    @Override
    public RegistrationResponse register(String confirmationToken) {

        ConfirmationToken confirmationTokenFound = null;

        try {
            confirmationTokenFound = confirmationTokenService.getConfirmationToken(confirmationToken).get();

            if (confirmationTokenFound != null) {

                log.info(logTitle + "confirmation token found by confirmation token");

                Boolean verifyResult = confirmationTokenService.verifyConfirmationToken(confirmationToken);

                if (verifyResult) {

                    log.info(logTitle + "confirmation token verified");

                    if (confirmationTokenService.setConfirmedAt(confirmationTokenFound.getConfirmationToken())) {

                        log.info(logTitle + "confirmation token confirmed successfully");

                        userService.setConfirmedUser(confirmationTokenFound.getUser());

                        log.info(logTitle + " user confirmed");

                        log.info(logTitle + "added to log user registered");

                        return new RegistrationResponse(
                                "user registered",
                                confirmationTokenFound.getUser().getEmail(),
                                confirmationTokenFound.getUser().getNickName()
                        );
                    } else {

                        log.error(logTitle + " confirmation token could not be confirmed");

                        throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, "token confirmation unsuccess");
                    }


                } else {

                    log.error(logTitle + "confirmation token not verified");

                    throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION, "not verified confirmation token");
                }

            } else {

                log.error(logTitle + "confirmation token not found");

                throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "not found confirmation token");
            }
        } catch (BaseExceptionModel exceptionModel) {

            log.error(logTitle + "user not confirmed because : " + exceptionModel.getErrorDescription());

            throw new UnSuccessfulException(UN_SUCCESSFUL_REGISTRATION,
                    exceptionModel.getErrorCode() + " : " + exceptionModel.getErrorDescription());
        }
    }

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {

        UserDto userDtoFound = null;
        User userFound = null;
        String _accessToken;
        String _refreshToken;

        try {
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

                if (userService.verifyUserPassword(userFound, loginRequest.getPassword())) {
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

                    log.error(logTitle + "user password not matched with sent password");

                    throw new UnAcceptableException(UN_ACCEPTABLE_USER_PASSWORD, "user password not matched with sent password");
                }

            } else {
                log.error(logTitle + "user not found for login");
                throw new NotFoundException(NOT_FOUND_USER, "user not found for login");
            }
        } catch (BaseExceptionModel exceptionModel) {
            log.error(logTitle + "user not login because : " + exceptionModel.getErrorDescription());

            throw new UnSuccessfulException(UN_SUCCESSFUL_LOGIN,
                    exceptionModel.getErrorCode() + " : " + exceptionModel.getErrorDescription());
        }


    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {

        RefreshToken refreshTokenFound;
        User userFound;

        try {
            refreshTokenFound = refreshTokenService.getRefreshTokenByToken(refreshToken).get();

            if (refreshTokenFound != null) {
                try {
                    if (refreshTokenService.verifyRefreshToken(refreshTokenFound)) {
                        throw new UnSuccessfulException(UN_SUCCESSFUL_REFRESH_TOKEN_RENEW, "refresh token is current still");
                    } else {
                        return null;
                    }
                } catch (BaseExceptionModel exceptionModel) {
                    if (exceptionModel.getErrorCode().startsWith(NOT_VALID_EXCEPTION_ERROR_CODE)) {

                        userFound = refreshTokenFound.getUser();

                        refreshTokenService.deleteRefreshToken(refreshTokenFound);

                        String accessToken = accessTokenService.createAccessTokenWithUserName(userFound.getNickName()).getAccessToken();
                        accessTokenService.verifyAccessToken(accessToken);

                        return new RefreshTokenResponse(
                                refreshTokenService.saveRefreshToken(refreshTokenService.createRefreshToken(userFound)).get().getRefreshToken(),
                                accessToken,
                                true,
                                true
                        );

                    } else {
                        throw new UnSuccessfulException(UN_SUCCESSFUL_REFRESH_TOKEN_RENEW, "refresh token is current still");

                    }
                }
            } else {

                throw new NotFoundException(NOT_FOUND_USER, "user not found by refresh token");
            }

        } catch (BaseExceptionModel exceptionModel) {

            log.error(logTitle + "refresh token not did not renew because : " + exceptionModel.getErrorDescription());

            throw new UnSuccessfulException(UN_SUCCESSFUL_REFRESH_TOKEN_RENEW,
                    exceptionModel.getErrorCode() + " : " + exceptionModel.getErrorDescription());
        }
    }

    @Override
    public LogOutResponse logOut(String refreshToken) {

        RefreshToken refreshTokenFound = null;
        User userFound;

        try {

                refreshTokenFound = refreshTokenService.getRefreshTokenByToken(refreshToken).get();

                refreshTokenService.deleteRefreshToken(refreshTokenFound);

                userService.addLogOutLogToUser(null,refreshTokenFound.getUser());

                return new LogOutResponse(true);


        } catch (BaseExceptionModel exceptionModel) {

            if(exceptionModel.getErrorCode().startsWith(NOT_FOUND_EXCEPTION_ERROR_CODE))
            {

            }
            else if(exceptionModel.getErrorCode().startsWith(ALREADY_EXIST_EXCEPTION_ERROR_CODE))
            {
                refreshTokenService.deleteRefreshToken(refreshTokenFound);

                userService.addLogOutLogToUser(null,refreshTokenFound.getUser());

                return new LogOutResponse(true);
            }

            log.error(logTitle + "user did not logout because : " + exceptionModel.getErrorDescription());

            throw new UnSuccessfulException(UN_SUCCESSFUL_LOGOUT,
                    exceptionModel.getErrorCode() + " : " + exceptionModel.getErrorDescription());
        }

    }
}
