package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthElementOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthElementOperationRepository extends JpaRepository<AuthElementOperation, String> {
}