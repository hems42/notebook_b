package com.notebook_b.org.service.concrete;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import com.notebook_b.org.service.abstracts.ITokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {
    @Override
    public String createAccessToken(String userNickName) {
        return null;
    }

    @Override
    public RefreshToken createRefreshToken(User user) {
        return null;
    }

    @Override
    public String createConfirmationToken(User user) {
        return null;
    }
}
