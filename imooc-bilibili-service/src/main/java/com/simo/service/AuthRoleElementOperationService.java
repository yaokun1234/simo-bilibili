package com.simo.service;

import com.simo.dao.entity.auth.AuthRoleElementOperation;
import com.simo.dao.repository.authRepository.AuthRoleElementOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author simo
 * @Date 2022/12/6 16:13
 * @Version 1.0
 **/

@Service
public class AuthRoleElementOperationService {

    @Autowired
    private AuthRoleElementOperationRepository authRoleElementOperationRepository;

    public List<AuthRoleElementOperation> findByRoleidIn(List<String> roleIds) {

        return authRoleElementOperationRepository.findAllByRoleidIn(roleIds);
    }
}
