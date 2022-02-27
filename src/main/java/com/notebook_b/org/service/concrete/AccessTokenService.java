package com.notebook_b.org.service.concrete;

import com.notebook_b.org.product.security.jwt_security.JwtTokenManager;
import com.notebook_b.org.service.abstracts.IAccessTokenService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class AccessTokenService implements IAccessTokenService {

   private final JwtTokenManager tokenManager;

   public AccessTokenService(JwtTokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public String createAccessTokenWithUserName(String userNickName){ return tokenManager.generateToken(userNickName); }

    @Override
    public Boolean verifyAccessToken(String accessToken)
    {
        return tokenManager.validateToken(accessToken);
    }

    @Override
    public String getUserNameFromAccessToken(String accessToken){return tokenManager.getUserNameFromToken(accessToken);}

    @Override
    public Boolean isNotExpired(String accessToken) {
        return tokenManager.isNotExpired(accessToken);
    }
}
