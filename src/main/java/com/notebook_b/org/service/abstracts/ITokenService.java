package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;

public interface ITokenService {

    String createAccessToken(String userNickName);

    RefreshToken createRefreshToken(User user);

    String createConfirmationToken(User user);
}
