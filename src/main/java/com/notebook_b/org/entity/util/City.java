package com.notebook_b.org.entity.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CityName",nullable = false,length = 60)
    private String cityName;

    @Column(name = "PlateCode",nullable = false,length = 10)
    private String plateCode;
}
