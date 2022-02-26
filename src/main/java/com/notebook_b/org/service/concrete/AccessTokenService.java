package com.notebook_b.org.service.concrete;

import com.notebook_b.org.product.security.jwt_security.JwtTokenManager;
import org.springframework.stereotype.Component;


@Component
public class AccessTokenService {

   private final JwtTokenManager tokenManager;

   public AccessTokenService(JwtTokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

   public String createAccessTokenWithUserName(String userNickName){ return tokenManager.generateToken(userNickName); }

    public Boolean verifyAccessToken(String accessToken)
    {
        return true;
    }
}
