package com.notebook_b.org.service.concrete;

import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.LogoutRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.SignUpResponse;
import com.notebook_b.org.service.abstracts.*;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final IUserService userService;
    private final IRegistrationService registrationService;
    private final IAccessTokenService accessTokenService;
    private final IRefreshTokenService refreshTokenService;
    private final IConfirmationTokenService confirmationTokenService;

    public AuthenticationService(IUserService userService,
                                 IRegistrationService registrationService,
                                 IAccessTokenService accessTokenService,
                                 IRefreshTokenService refreshTokenService,
                                 IConfirmationTokenService confirmationTokenService) {
        this.userService = userService;
        this.registrationService = registrationService;
        this.accessTokenService = accessTokenService;
        this.refreshTokenService = refreshTokenService;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signupRequest) {
        return null;
    }

    @Override
    public void register() {

    }

    @Override
    public LoginResponse logIn(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public void refreshToken() {

    }

    @Override
    public LogoutRequest logOut(LogoutRequest logoutRequest) {
        return null;
    }
}
