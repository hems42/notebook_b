package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import java.util.Optional;

public interface IConfirmationTokenService {

    ConfirmationToken createConfirmationToken(User user);

    Optional<ConfirmationToken> saveConfirmationToken(ConfirmationToken token);

    Optional<ConfirmationToken> getConfirmationToken(String token);

    Optional<ConfirmationToken> getConfirmationToken(User user);

    Boolean setConfirmedAt(String token);

    Boolean deleteConfirmationToken(ConfirmationToken confirmationToken);

    Boolean deleteConfirmationToken(Integer tokenId);

    Boolean deleteConfirmationToken(String  confirmationToken);

    Boolean deleteConfirmationToken(User user);

    Boolean verifyConfirmationToken(String confirmationToken);
}
