package com.notebook_b.org.service.concrete;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import com.notebook_b.org.repository.ConfirmationTokenDao;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationTokenService {

    private final ConfirmationTokenDao confirmationTokenDao;

    public ConfirmationTokenService(ConfirmationTokenDao confirmationTokenDao) {
        this.confirmationTokenDao = confirmationTokenDao;
    }

    public ConfirmationToken createConfirmationToken(User user){ return null;}

    public Boolean verifyConfirmationToken(ConfirmationToken confirmationToken){ return true;}

    public Boolean confirmToken(String token){ return true;}

    public void deleteConfirmationTokenByToken(ConfirmationToken confirmationToken){}

    public void deleteConfirmationTokenByUser(User user){}

//    public void deleteConfirmationTokenByToken(ConfirmationToken confirmationToken){}
//
//    public void deleteConfirmationTokenByToken(ConfirmationToken confirmationToken){}
}
