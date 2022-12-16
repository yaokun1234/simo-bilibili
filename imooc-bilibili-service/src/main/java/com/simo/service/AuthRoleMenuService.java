package com.simo.service;

import com.simo.dao.entity.auth.AuthRoleMenu;
import com.simo.dao.repository.authRepository.AuthRoleMenuRepository;
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
public class AuthRoleMenuService {

    @Autowired
    private AuthRoleMenuRepository authRoleMenuRepository;

    public List<AuthRoleMenu> findByRoleidIn(List<String> roleIds) {
        return authRoleMenuRepository.findAllByRoleidIn(roleIds);
    }
}
