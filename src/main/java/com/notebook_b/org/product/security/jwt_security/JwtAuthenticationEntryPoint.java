package com.notebook_b.org.product.security.jwt_security;

import  com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import com.notebook_b.org.core.exceptions.exceptionModel.UnAuthorizeException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        BaseExceptionModel exceptionModel  = new UnAuthorizeException(CoreEnumExceptionMessages.UNAUTHORIZED_REQUEST,"");
        response.addHeader("errorCode",exceptionModel.getErrorCode().toString());
        response.addHeader("errorMessage", exceptionModel.getErrorMessage());
        response.addHeader("errorDescription", exceptionModel.getErrorDescription());
        
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

    }

}
