package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleMenuRepository extends JpaRepository<AuthRoleMenu, String> {
}