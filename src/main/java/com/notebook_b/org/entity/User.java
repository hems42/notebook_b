package com.notebook_b.org.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Users")
public abstract class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "NickName", nullable = false, length = 50)
    private String nickName;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Password", nullable = false, length = 250)
    private String password;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;
}
