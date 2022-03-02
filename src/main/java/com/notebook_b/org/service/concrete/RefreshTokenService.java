package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnSuccessfulException;
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

        if (util_isNotExistRefreshToken(user)) {
            return new RefreshToken(
                    null,
                    user,
                    UUID.randomUUID().toString(),
                    Instant.now().plusMillis(AppConstants.REFRESH_TOKEN_EXPERIMENT_TIME),
                    LocalDateTime.now()
            );
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_CREATED_REFRESH_TOKEN, "not created refresh token");
        }
    }

    @Override
    public Optional<RefreshToken> saveRefreshToken(RefreshToken refreshToken) {

        if (util_isNotExistRefreshToken(refreshToken.getRefreshToken())) {
            return Optional.of(refreshTokenDao.save(refreshToken));
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_SAVED_REFRESH_TOKEN, "not added refresh token");
        }
    }

    @Override
    public Optional<RefreshToken> getRefreshTokenByToken(String refreshToken) {
        return Optional.of(util_getRefreshToken(refreshToken));
    }

    @Override
    public Optional<RefreshToken> getRefreshTokenByUser(User user) {
        return Optional.of(util_getRefreshToken(user));
    }

    @Override
    public Boolean verifyRefreshToken(RefreshToken refreshToken) {
        return util_verifyRefreshToken(refreshToken);
    }

    @Override
    public Boolean verifyRefreshToken(User user) {
        RefreshToken refreshTokenFound = util_getRefreshToken(user);
        return util_verifyRefreshToken(refreshTokenFound);
    }

    @Override
    public Boolean deleteRefreshToken(RefreshToken refreshToken) {
        if (util_isNotExistRefreshToken(refreshToken)) {
            return refreshTokenDao.deleteByRefreshToken(refreshToken) > 0;
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_DELETED_REFRESH_TOKEN, "not deleted refresh token with refresh token");
        }

    }

    @Override
    public Boolean deleteRefreshToken(User user) {
        if (util_isNotExistRefreshToken(user)) {
            return refreshTokenDao.deleteByUser(user) > 0;
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_DELETED_REFRESH_TOKEN, "not deleted refresh token with user");
        }
    }


    //***********************************************//

    //UTIL

    private RefreshToken util_getRefreshToken(Integer id) {

        RefreshToken refreshTokenFound = refreshTokenDao.getById(id);

        if (refreshTokenFound != null) {
            return refreshTokenFound;
        } else {
            throw new NotFoundException(NOT_FOUND_REFRESH_TOKEN, "not found refresh token by ıd");
        }
    }

    private RefreshToken util_getRefreshToken(User user) {

        RefreshToken refreshTokenFound = refreshTokenDao.getByUser(user);

        if (refreshTokenFound != null) {
            return refreshTokenFound;
        } else {
            throw new NotFoundException(NOT_FOUND_REFRESH_TOKEN, "not found refresh token by user");
        }
    }

    private RefreshToken util_getRefreshToken(String refreshToken) {

        RefreshToken refreshTokenFound = refreshTokenDao.getByRefreshToken(refreshToken);

        if (refreshTokenFound != null) {
            return refreshTokenFound;
        } else {
            throw new NotFoundException(NOT_FOUND_REFRESH_TOKEN, "not found refresh token by refresh token");
        }
    }

    private RefreshToken util_getRefreshToken(RefreshToken refreshToken) {

        RefreshToken refreshTokenFound = refreshTokenDao.getRefreshTokenByRefreshToken(refreshToken);

        if (refreshTokenFound != null) {
            return refreshTokenFound;
        } else {
            throw new NotFoundException(NOT_FOUND_REFRESH_TOKEN, "not found refresh token");
        }
    }

    private Boolean util_isNotExistRefreshToken(Integer id) {

        RefreshToken refreshTokenFound = refreshTokenDao.getById(id);

        if (refreshTokenFound == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN, "refresh token found by id");
        }
    }

    private Boolean util_isNotExistRefreshToken(User user) {

        RefreshToken refreshTokenFound = refreshTokenDao
                .getByUser(user);

        if (refreshTokenFound == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN, "refresh token found by user");
        }
    }

    private Boolean util_isNotExistRefreshToken(String refreshToken) {

        RefreshToken refreshTokenFound = refreshTokenDao.getByRefreshToken(refreshToken);

        if (refreshTokenFound == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN,
                    "refresh token found by refresh token");
        }
    }

    private Boolean util_isNotExistRefreshToken(RefreshToken refreshToken) {

        RefreshToken refreshTokenFound = refreshTokenDao.getRefreshTokenByRefreshToken(refreshToken);

        if (refreshTokenFound == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_REFRESH_TOKEN,
                    "refresh token found");
        }
    }

    private Boolean util_verifyRefreshToken(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {

            refreshTokenDao.delete(refreshToken);

            throw new NotValidException(NOT_VALID_REFRESH_TOKEN_EXPIRED, "");

        } else {
            return true;
        }
    }
}
