package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;

import java.util.Optional;

public interface IRefreshTokenService {

    RefreshToken createRefreshToken(User user);

    Optional<RefreshToken> saveRefreshToken(RefreshToken refreshToken);

    Optional<RefreshToken> getRefreshTokenByToken(String refreshToken);

    Optional<RefreshToken> getRefreshTokenByUser(User user);

    Optional<User> getUserByRefreshToken(RefreshToken refreshToken);

    Boolean verifyRefreshToken(RefreshToken refreshToken);

    Boolean verifyRefreshToken(User user);

    Boolean deleteRefreshToken(RefreshToken refreshToken);

    Boolean deleteRefreshToken(User user);

}
