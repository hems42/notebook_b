package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import com.notebook_b.org.product.appConstants.AppConstants;
import com.notebook_b.org.repository.RefreshTokenDao;
import com.notebook_b.org.service.abstracts.IRefreshTokenService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;

@Service
public class RefreshTokenService implements IRefreshTokenService {

    private final RefreshTokenDao refreshTokenDao;

    public RefreshTokenService(RefreshTokenDao refreshTokenDao) {
        this.refreshTokenDao = refreshTokenDao;
    }

    @Override
    public RefreshToken createRefreshToken(User user) {
        return new RefreshToken(
                null,
                user,
                UUID.randomUUID().toString(),
                Instant.now().plusMillis(AppConstants.REFRESH_TOKEN_EXPERIMENT_TIME),
                LocalDateTime.now()
        );
    }

    @Override
    public Optional<RefreshToken> saveRefreshToken(RefreshToken refreshToken) {
        return Optional.of(refreshTokenDao.save(refreshToken));
    }

    @Override
    public Optional<RefreshToken> getRefreshTokenByToken(String refreshToken) {
        return refreshTokenDao.findByRefreshToken(refreshToken);
    }

    @Override
    public Optional<RefreshToken> getRefreshTokenByUser(User user) {
        return refreshTokenDao.findByUser(user);
    }

    @Override
    public Boolean verifyRefreshToken(RefreshToken refreshToken) {

        RefreshToken refreshTokenFound = refreshTokenDao.findByUser(refreshToken.getUser()).get();

        if (refreshTokenFound == null) {
            throw new NotFoundException(NOT_FOUND_REFRESH_TOKEN, "not found refresh token");
        } else if (refreshTokenFound.getExpiryDate().compareTo(Instant.now()) < 0) {

            refreshTokenDao.delete(refreshToken);

            throw new NotValidException(NOT_VALID_REFRESH_TOKEN_EXPIRED, "");

        } else {
            return true;
        }
    }

    @Override
    public Boolean deleteRefreshToken(RefreshToken refreshToken) {
        return refreshTokenDao.deleteByRefreshToken(refreshToken) > 0;
    }

    @Override
    public Boolean deleteRefreshToken(User user) {
        return refreshTokenDao.deleteByUser(user) > 0;
    }

}
