package com.notebook_b.org.repository;

import com.notebook_b.org.entity.security.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken,Integer> {

    Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);
}
