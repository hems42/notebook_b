package com.notebook_b.org.entity;

import com.notebook_b.org.entity.util.City;
import com.notebook_b.org.entity.util.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AddressDescription",nullable = false,length = 50)
    private String addressDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId",nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DistrictId",nullable = false)
    private District district;

    @Column(name = "Street",nullable = false,length = 50)
    private String street;

    @Column(name = "DoorNumberInside",length = 10)
    private String doorNumberInside;

    @Column(name = "DoorNumberOutside",nullable = false,length = 10)
    private String doorNumberOutside;

    @Column(name = "AddressDetail",nullable = false,length = 250)
    private String addressDetail;
}
