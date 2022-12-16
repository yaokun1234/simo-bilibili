package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, String> {
    AuthRole findByCode(String code);
}