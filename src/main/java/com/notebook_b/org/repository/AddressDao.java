package com.notebook_b.org.repository;


import com.notebook_b.org.entity.communication.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer> {
}
