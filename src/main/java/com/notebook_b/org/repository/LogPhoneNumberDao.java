package com.notebook_b.org.repository;

import com.notebook_b.org.entity.log.LogPhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogPhoneNumberDao extends JpaRepository<LogPhoneNumber,Integer> {
}
