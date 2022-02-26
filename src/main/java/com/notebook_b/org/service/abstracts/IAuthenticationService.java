package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.request.authenticate.LogOutRequest;
import com.notebook_b.org.product.request.authenticate.LoginRequest;
import com.notebook_b.org.product.request.authenticate.SignUpRequest;
import com.notebook_b.org.product.response.LoginResponse;
import com.notebook_b.org.product.response.SignUpResponse;

public interface IAuthenticationService {

    LoginResponse logIn(LoginRequest loginRequest);

    LogOutRequest logOut(LogOutRequest logOutRequest);

    SignUpResponse signUp(SignUpRequest signUpRequest);
}
