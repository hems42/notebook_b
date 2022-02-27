package com.notebook_b.org.repository;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    Optional<RefreshToken> findByUser(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM RefreshTokens r WHERE r = ?1")
    Integer deleteByRefreshToken(RefreshToken refreshToken);

    @Transactional
    @Modifying
    @Query("DELETE FROM RefreshTokens r WHERE r.user = ?1")
    Integer deleteByUser(User user);
}
