package com.notebook_b.org.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String addressDescription;

    private String city;

    private String district;

    private String street;

    private String doorNumber;

    private String addressDetail;
}
