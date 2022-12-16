package com.simo.service;

import com.simo.dao.entity.auth.AuthRole;
import com.simo.dao.repository.authRepository.AuthRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author simo
 * @Date 2022/12/7 12:40
 * @Version 1.0
 **/

@Service
public class AuthRoleService {

    @Autowired
    private AuthRoleRepository authRoleRepository;

    public AuthRole findByRoleCode(String code) {

        return authRoleRepository.findByCode(code);
    }
}
