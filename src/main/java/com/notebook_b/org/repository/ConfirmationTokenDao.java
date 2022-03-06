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

    //SELECT
    Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);

    Optional<ConfirmationToken> findByUser(User user);

    @Query( "SELECT c " +
            "FROM ConfirmationTokens c " +
            "WHERE c.tokenId = ?1")
    ConfirmationToken getConfirmationTokenByTokenId (Integer tokenId);

    @Query( "SELECT c " +
            "FROM ConfirmationTokens c " +
            "WHERE c.confirmationToken = ?1")
    ConfirmationToken getConfirmationTokenByConfirmationToken (String confirmationToken);

    @Query( "SELECT c " +
            "FROM ConfirmationTokens c " +
            "WHERE c.user = ?1")
    ConfirmationToken getConfirmationTokenByUser (User user);

    //UPDATE
    @Transactional
    @Modifying
    @Query( "UPDATE ConfirmationTokens c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.confirmationToken = ?1")
    Integer updateConfirmedAt(String token, LocalDateTime confirmedAt);


    //DELETE
    @Transactional
    @Modifying
    @Query( "DELETE " +
            "FROM ConfirmationTokens c " +
            "WHERE c = ?1")
    Integer deleteByConfirmationToken(ConfirmationToken confirmationToken);

    @Transactional
    @Modifying
    @Query( "DELETE " +
            "FROM ConfirmationTokens c " +
            "WHERE c.tokenId = ?1")
    Integer deleteByTokenId(Integer tokenId);

    @Transactional
    @Modifying
    @Query( "DELETE " +
            "FROM ConfirmationTokens c " +
            "WHERE c.confirmationToken = ?1")
    Integer deleteByConfirmationToken(String confirmationToken);

    @Transactional
    @Modifying
    @Query( "DELETE " +
            "FROM ConfirmationTokens c " +
            "WHERE c.user = ?1")
    Integer deleteByUser(User user);


    //EXIST
    Boolean existsByTokenId(Integer tokenId);

    Boolean existsByConfirmationToken(String confirmationToken);

    Boolean existsByUser(User user);
}
