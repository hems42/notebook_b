package com.notebook_b.org.entity.log;


import com.notebook_b.org.entity.User;
import com.notebook_b.org.entity.enums.EnumCrud;
import com.notebook_b.org.entity.util.City;

import javax.persistence.*;
import java.time.LocalDateTime;

public class LogCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumCrud crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
