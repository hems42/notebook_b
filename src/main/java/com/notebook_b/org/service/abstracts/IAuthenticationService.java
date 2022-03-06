package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.request.authenticate.LogoutRequest;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.RegistrationResponse;
import com.notebook_b.org.product.response.SignUpResponse;

public interface IAuthenticationService {

    SignUpResponse signUp(SignUpRequest signupRequest);

    RegistrationResponse register(String confirmationToken);

    LoginResponse logIn(LoginRequest loginRequest);

    void refreshToken();

    LogoutRequest logOut(LogoutRequest logoutRequest);}
