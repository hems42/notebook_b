package com.notebook_b.org.repository;

import com.notebook_b.org.entity.log.LogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogUserDao extends JpaRepository<LogUser,Integer> {
}
