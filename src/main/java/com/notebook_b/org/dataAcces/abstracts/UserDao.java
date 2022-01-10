package com.notebook_b.org.dataAcces.abstracts;

import com.notebook_b.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
}
