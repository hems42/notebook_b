package com.notebook_b.org.dao;


import com.notebook_b.org.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer> {
}
