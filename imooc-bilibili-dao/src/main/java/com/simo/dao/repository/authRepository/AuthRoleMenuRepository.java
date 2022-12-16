package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRoleMenuRepository extends JpaRepository<AuthRoleMenu, String> {

    List<AuthRoleMenu> findAllByRoleidIn(List<String> roleids);
}