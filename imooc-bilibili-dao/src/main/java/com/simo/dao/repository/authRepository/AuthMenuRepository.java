package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthMenuRepository extends JpaRepository<AuthMenu, String> {
}