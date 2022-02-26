package com.notebook_b.org.repository;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenDao extends JpaRepository< RefreshToken,Integer> {

    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUser(User user);

    @Modifying
    int deleteByUser(User user);
}
