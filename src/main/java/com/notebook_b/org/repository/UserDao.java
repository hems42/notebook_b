package com.notebook_b.org.repository;

import com.notebook_b.org.entity.leadRole.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,String> {

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.email = ?1")
    User getUserByEmail(String email);

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.nickName = ?1")
    User getUserByNickName(String userNickName);

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.nickName = ?1 or u.email = ?2")
    User getUserByNickNameOrEmail(String userNickName, String email);
}
