package com.notebook_b.org.dao;

import com.notebook_b.org.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberDao extends JpaRepository<PhoneNumber,Integer> {
}
