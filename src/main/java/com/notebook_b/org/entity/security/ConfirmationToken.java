package com.notebook_b.org.entity.security;

import com.notebook_b.org.entity.leadRole.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ConfirmationTokens")
public class ConfirmationToken  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    @ManyToOne
    @JoinColumn(
            name = "UserId",
            nullable = false
    )
    private User user;

    @Column(name ="ConfirmationToken",nullable = false,unique = true )
    private String confirmationToken;

    @Column(name ="CreatedAt",nullable = false ,updatable = false)
    private LocalDateTime createdAt;

    @Column(name ="ExpiresAt",nullable = false )
    private LocalDateTime expiresAt;

    @Column(name = "ConfirmedAt")
    private LocalDateTime confirmedAt;
}
