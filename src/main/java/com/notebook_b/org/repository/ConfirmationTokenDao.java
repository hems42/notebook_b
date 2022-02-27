package com.notebook_b.org.repository;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.security.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken, Integer> {

    Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);

    Optional<ConfirmationToken> findByUser(User user);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationTokens c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.confirmationToken = ?1")
    Integer updateConfirmedAt(String token, LocalDateTime confirmedAt);

    @Transactional
    @Modifying
    @Query("DELETE FROM ConfirmationTokens c WHERE c = ?1")
    Integer deleteByConfirmationToken(ConfirmationToken confirmationToken);

    @Transactional
    @Modifying
    @Query("DELETE FROM ConfirmationTokens c WHERE c.user = ?1")
    Integer deleteByUser(User user);
}
