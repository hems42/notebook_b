package com.notebook_b.org.service.concrete;

import com.notebook_b.org.product.response.AccessTokenResponse;
import com.notebook_b.org.product.security.jwt_security.JwtTokenManager;
import com.notebook_b.org.service.abstracts.IAccessTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService implements IAccessTokenService {

   private final JwtTokenManager tokenManager;

   private final AuthenticationManager authenticationManager;

   public AccessTokenService(JwtTokenManager tokenManager, AuthenticationManager authenticationManager) {
       this.tokenManager = tokenManager;
       this.authenticationManager = authenticationManager;
   }

    @Override
    public Authentication authenticateUser(String userName, String password) {
        return authenticationManager.authenticate(getSecurityUser(userName,password));
    }

    @Override
    public AccessTokenResponse createAccessTokenWithUserName(String userNickName){
       return new AccessTokenResponse(tokenManager.generateToken(userNickName)); }

    @Override
    public Boolean verifyAccessToken(String accessToken)
    {
        return tokenManager.validateToken(accessToken);
    }

    @Override
    public String getUserNameFromAccessToken(String accessToken){return tokenManager.getUserNameFromToken(accessToken);}

    @Override
    public String getAccessTokenFromUserName(String userName) {
        return null;
    }


    @Override
    public Boolean isNotExpired(String accessToken) {
        return tokenManager.isNotExpired(accessToken);
    }

    private UsernamePasswordAuthenticationToken getSecurityUser(String userNickName,String password){
        return new UsernamePasswordAuthenticationToken(userNickName,password);
    }
}
