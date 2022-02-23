package com.notebook_b.org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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

    @Column(name = "NickName", nullable = false, length = 50, unique = true)
    private String nickName;

    @Column(name = "Email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "Password", nullable = false, length = 200)
    private String password;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "IsRegistered", nullable = false)
    private Boolean isRegistered;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "UserId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "RoleId")
            }
    )
    private Set<Role> roles;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;
}
