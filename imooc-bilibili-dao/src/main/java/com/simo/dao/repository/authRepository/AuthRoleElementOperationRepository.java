package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthRoleElementOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleElementOperationRepository extends JpaRepository<AuthRoleElementOperation, String> {
}