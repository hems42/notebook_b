package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.request.authenticate.LogoutRequest;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.SignUpResponse;

public interface IAuthenticationService {

    LoginResponse logIn(LoginRequest loginRequest);

    LogoutRequest logOut(LogoutRequest logoutRequest);

    SignUpResponse signUp(SignUpRequest signupRequest);

    void register();

    void refreshToken();
}
