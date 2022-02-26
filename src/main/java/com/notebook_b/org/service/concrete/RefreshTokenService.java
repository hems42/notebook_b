package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import com.notebook_b.org.product.appConstants.AppConstants;
import com.notebook_b.org.repository.RefreshTokenDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class RefreshTokenService {

    private final RefreshTokenDao refreshTokenDao;

    public RefreshTokenService(RefreshTokenDao refreshTokenDao) { this.refreshTokenDao = refreshTokenDao; }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now()
                .plusMillis(AppConstants.REFRESH_TOKEN_DURATION_DAY));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenDao.save(refreshToken);
    }

    public Optional<RefreshToken> findTokenByToken(String token) {
        return refreshTokenDao.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenDao.delete(token);
            throw new NotValidException(CoreEnumExceptionMessages.NOT_VALID_REFRESH_TOKEN, "token süresi dolmuş");
        }
        return token;
    }

    public Boolean verifyRefreshToken(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenDao.delete(token);
            throw new NotValidException(CoreEnumExceptionMessages.NOT_VALID_REFRESH_TOKEN, "token süresi dolmuş");
        }
        return true;
    }

    @Transactional
    public int deleteByUserId(User user) {
        return refreshTokenDao.deleteByUser(user);
    } }
