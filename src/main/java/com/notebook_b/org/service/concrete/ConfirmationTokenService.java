package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyAcceptedException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import com.notebook_b.org.product.appConstants.AppConstants;
import com.notebook_b.org.repository.ConfirmationTokenDao;
import com.notebook_b.org.service.abstracts.IConfirmationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;

@Slf4j
@Service
public class ConfirmationTokenService implements IConfirmationTokenService {

    private final ConfirmationTokenDao confirmationTokenRepository;

    private final String logTitle = "ConfirmationTokenService ";

    public ConfirmationTokenService(ConfirmationTokenDao confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public ConfirmationToken createConfirmationToken(User user) {

        return new ConfirmationToken(
                null,
                user,
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(AppConstants.CONFIRMATION_TOKEN_EXPERIMENT_TIME),
                null
        );
    }

    @Override
    public Boolean verifyConfirmationToken(String confirmationToken) {

        return util_verifyConfirmationToken(confirmationToken);
    }

    @Override
    public Optional<ConfirmationToken> saveConfirmationToken(ConfirmationToken token) {

        log.info(logTitle + "confirmation token saved");

        return Optional.of(confirmationTokenRepository.save(token));
    }

    @Override
    public Optional<ConfirmationToken> getConfirmationToken(String token) {

        return Optional.of(util_getConfirmationToken(token));
    }

    @Override
    public Optional<ConfirmationToken> getConfirmationToken(User user) {

        return Optional.of(util_getConfirmationToken(user));
    }

    @Override
    public Boolean setConfirmedAt(String token) {

        if (confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now()) > 0) {

            log.info(logTitle + "confirmation token confirmed");

            return true;

        } else {

            log.error(logTitle + " confirmation token not confirmed");

            return false;
        }
    }

    @Override
    public Boolean deleteConfirmationToken(ConfirmationToken confirmationToken) {

        return util_deleteConfirmationToken(confirmationToken);
    }

    @Override
    public Boolean deleteConfirmationToken(Integer tokenId) {

        return util_deleteConfirmationToken(tokenId);
    }

    @Override
    public Boolean deleteConfirmationToken(String confirmationToken) {

        return util_deleteConfirmationToken(confirmationToken);
    }

    @Override
    public Boolean deleteConfirmationToken(User user) {

        return util_deleteConfirmationToken(user);
    }


    //***********************************************//

    //UTIL

    private ConfirmationToken util_getConfirmationToken(Integer tokenId) {

        ConfirmationToken confirmationTokenFound = confirmationTokenRepository.getConfirmationTokenByTokenId(tokenId);

        if (confirmationTokenFound != null) {
            log.info(logTitle + "confirmation token fetched by tokenId");
            return confirmationTokenFound;
        } else {

            log.error(logTitle + "confirmation token not fetched by tokenId");
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token not fetched by tokenId");
        }

    }

    private ConfirmationToken util_getConfirmationToken(String confirmationToken) {

        ConfirmationToken confirmationTokenFound = confirmationTokenRepository.getConfirmationTokenByConfirmationToken(confirmationToken);

        if (confirmationTokenFound != null) {
            log.info(logTitle + "confirmation token fetched by confirmationToken");
            return confirmationTokenFound;
        } else {

            log.error(logTitle + "confirmation token not fetched by confirmationToken");
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token not fetched by confirmationToken");
        }

    }

    private ConfirmationToken util_getConfirmationToken(User user) {

        ConfirmationToken confirmationTokenFound = confirmationTokenRepository.getConfirmationTokenByUser(user);

        if (confirmationTokenFound != null) {
            log.info(logTitle + "confirmation token fetched by user");
            return confirmationTokenFound;
        } else {

            log.error(logTitle + "confirmation token not fetched by user");
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token not fetched by user");
        }

    }

    private Boolean util_isExistConfirmationToken(Integer tokenId) {

        if (confirmationTokenRepository.existsByTokenId(tokenId)) {
            log.info(logTitle + "confirmation token found by ıd");
            return true;
        } else {
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token found by ıd");
        }
    }

    private Boolean util_isExistConfirmationToken(String confirmationToken) {

        if (confirmationTokenRepository.existsByConfirmationToken(confirmationToken)) {
            log.info(logTitle + "confirmation token found by confirmationToken");
            return true;
        } else {
            log.error(logTitle + "confirmation token found by confirmationToken");
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token found by confirmationToken");
        }
    }

    private Boolean util_isExistConfirmationToken(User user) {

        if (confirmationTokenRepository.existsByUser(user)) {
            log.info(logTitle + "confirmation token found by user");
            return true;
        } else {
            log.error(logTitle + "confirmation token found by user");
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token found by user");
        }
    }

    private Boolean util_verifyConfirmationToken(Integer tokenId) {

        ConfirmationToken confirmationTokenFound = util_getConfirmationToken(tokenId);

        return util_i_verifyConfirmationToken(confirmationTokenFound, "tokenId");
    }

    private Boolean util_verifyConfirmationToken(String confirmationToken) {

        ConfirmationToken confirmationTokenFound = util_getConfirmationToken(confirmationToken);

        return util_i_verifyConfirmationToken(confirmationTokenFound, "string confirmationToken");
    }

    private Boolean util_verifyConfirmationToken(User user) {

        ConfirmationToken confirmationTokenFound = util_getConfirmationToken(user);

        return util_i_verifyConfirmationToken(confirmationTokenFound, "user");
    }

    private Boolean util_deleteConfirmationToken(Integer tokenId) {

        if (confirmationTokenRepository.deleteByTokenId(tokenId) > 0) {

            log.info(logTitle + "confirmation token deleted by token ıd");
            return true;
        } else {
            log.error(logTitle + "confirmation token could not deleted by token ıd");
            return false;
        }
    }

    private Boolean util_deleteConfirmationToken(ConfirmationToken confirmationToken) {

        if (confirmationTokenRepository.deleteByConfirmationToken(confirmationToken) > 0) {

            log.info(logTitle + "confirmation token deleted by confirmationToken");

            return true;

        } else {

            log.error(logTitle + "confirmation token could not deleted by confirmationToken");

            return false;
        }
    }

    private Boolean util_deleteConfirmationToken(String confirmationToken) {

        if (confirmationTokenRepository.deleteByConfirmationToken(confirmationToken) > 0) {

            log.info(logTitle + "confirmation token deleted by string confirmationToken");

            return true;

        } else {

            log.error(logTitle + "confirmation token could not deleted by string confirmationToken");

            return false;
        }
    }

    private Boolean util_deleteConfirmationToken(User user) {

        if (confirmationTokenRepository.deleteByUser(user) > 0) {

            log.info(logTitle + "confirmation token deleted by user");

            return true;

        } else {

            log.error(logTitle + "confirmation token could not deleted by user");

            return false;
        }
    }


    //-- sub util
    private Boolean util_i_verifyConfirmationToken(ConfirmationToken confirmationToken, String loggedBy) {

        if (confirmationToken.getConfirmedAt() != null) {

            log.error(logTitle + "confirmation token already confirmed -" + loggedBy);
            throw new AlReadyAcceptedException(ALREADY_ACCEPTED_CONFIRMATION_TOKEN_CONFIRMED,
                    "confirmation token already confirmed");

        } else if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {

            util_deleteConfirmationToken(confirmationToken);

            log.error(logTitle + "confirmation token expired and deleted found token -" + loggedBy);

            throw new NotValidException(NOT_VALID_CONFIRMATION_TOKEN_EXPIRED,
                    "confirmation token is expired and deleted found token");

        } else {
            log.info(logTitle + "log verified -" + loggedBy);
            return true;
        }

    }

}
