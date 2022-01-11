package com.notebook_b.org.entity.log;

import com.notebook_b.org.entity.PhoneNumber;
import com.notebook_b.org.entity.User;
import com.notebook_b.org.entity.enums.EnumCrud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogPhoneNumbers")
public class LogPhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumCrud crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PhoneNumberId",nullable = false)
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
