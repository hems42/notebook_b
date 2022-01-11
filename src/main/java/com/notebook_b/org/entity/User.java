package com.notebook_b.org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "NickName", nullable = false, length = 50)
    private String nickName;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Password", nullable = false, length = 200)
    private String password;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "IsRegistered", nullable = false)
    private Boolean isRegistered;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;
}
