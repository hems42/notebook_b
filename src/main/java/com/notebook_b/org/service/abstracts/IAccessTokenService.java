package com.notebook_b.org.service.abstracts;

public interface IAccessTokenService {

    String createAccessTokenWithUserName(String userNickName);

    Boolean verifyAccessToken(String accessToken);

    String getUserNameFromAccessToken(String accessToken);

    Boolean isNotExpired(String accessToken);

}
