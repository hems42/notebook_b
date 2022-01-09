package com.notebook_b.org.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
