package com.notebook_b.org.dao;

import com.notebook_b.org.entity.util.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
