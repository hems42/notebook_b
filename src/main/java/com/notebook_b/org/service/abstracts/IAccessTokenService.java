package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.response.AccessTokenResponse;
import org.springframework.security.core.Authentication;

public interface IAccessTokenService {

    Authentication authenticateUser(String userName, String password);

    AccessTokenResponse createAccessTokenWithUserName(String userNickName);

    Boolean verifyAccessToken(String accessToken);

    String getUserNameFromAccessToken(String accessToken);

    Boolean isNotExpired(String accessToken);

}
