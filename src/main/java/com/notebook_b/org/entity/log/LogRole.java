package com.notebook_b.org.entity.log;

import com.notebook_b.org.product.appEnums.AppEnumCrud;
import com.notebook_b.org.entity.Role;
import com.notebook_b.org.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogRoles")
public class LogRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AppEnumCrud crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleId",nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
