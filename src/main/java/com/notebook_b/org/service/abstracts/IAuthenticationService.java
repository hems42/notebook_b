package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.request.authenticate.LogoutRequest;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.*;

public interface IAuthenticationService {

    SignUpResponse signUp(SignUpRequest signupRequest);

    RegistrationResponse register(String confirmationToken);

    LoginResponse logIn(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(String refreshToken, String accessToken);

    LogOutResponse logOut(String refreshToken);



}
