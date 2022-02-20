package com.notebook_b.org.repository;

import com.notebook_b.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,String> {

    @Query("SELECT u FROM User u WHERE u.nickName = ?1")
    User getUserByNickName(String userNickName);
}
