package com.simo.dao.repository.authRepository;

import com.simo.dao.entity.auth.AuthRoleElementOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRoleElementOperationRepository extends JpaRepository<AuthRoleElementOperation, String> {

    List<AuthRoleElementOperation> findAllByRoleidIn(List<String> roleids);
}
