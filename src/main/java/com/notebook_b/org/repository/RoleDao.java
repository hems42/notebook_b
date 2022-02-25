package com.notebook_b.org.repository;

import com.notebook_b.org.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleDao extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role getRoleByRoleName(String roleName);
}
