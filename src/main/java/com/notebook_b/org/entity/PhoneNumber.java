package com.notebook_b.org.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "PhoneNumber", nullable = false, length = 15)
    private String phoneNumber;

    @ManyToOne
    private User userId;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate", insertable = false)
    private LocalDateTime updatedDate;

}
