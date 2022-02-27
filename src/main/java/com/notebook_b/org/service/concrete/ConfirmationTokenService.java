package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyAcceptedException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import com.notebook_b.org.product.appConstants.AppConstants;
import com.notebook_b.org.repository.ConfirmationTokenDao;
import com.notebook_b.org.service.abstracts.IConfirmationTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;

@Service
public class ConfirmationTokenService implements IConfirmationTokenService {

    private final ConfirmationTokenDao confirmationTokenDao;

    public ConfirmationTokenService(ConfirmationTokenDao confirmationTokenDao) {
        this.confirmationTokenDao = confirmationTokenDao;
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

        ConfirmationToken confirmToken = confirmationTokenDao.findByConfirmationToken(confirmationToken).get();

        if (confirmToken == null) {
            throw new NotFoundException(NOT_FOUND_CONFIRMATION_TOKEN, "confirmation token not found");
        }
        else if (confirmToken.getConfirmedAt() != null) {
            throw new AlReadyAcceptedException(ALREADY_ACCEPTED_E_MAIL_ADDRESS, "mail address accepted already");
        }
        else if (confirmToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new NotValidException(NOT_VALID_CONFIRMATION_TOKEN_EXPIRED, "confirmation token is expired");
        }
        else {
            return true;
        }
    }

    @Override
    public Optional<ConfirmationToken> saveConfirmationToken(ConfirmationToken token) {
        return Optional.of(confirmationTokenDao.save(token));
    }

    @Override
    public Optional<ConfirmationToken> getConfirmationToken(String token) {
        return confirmationTokenDao.findByConfirmationToken(token);
    }

    @Override
    public Optional<ConfirmationToken> getConfirmationToken(User user) {
        return confirmationTokenDao.findByUser(user);
    }

    @Override
    public Boolean setConfirmedAt(String token) {
        return confirmationTokenDao.updateConfirmedAt(token,LocalDateTime.now())>0;
    }

    @Override
    public Boolean deleteConfirmationToken(ConfirmationToken confirmationToken) {
        return confirmationTokenDao.deleteByConfirmationToken(confirmationToken)>0;
    }

    @Override
    public Boolean deleteConfirmationToken(User user) {
        return confirmationTokenDao.deleteByUser(user)>0;
    }

}
