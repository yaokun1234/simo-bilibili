package com.simo.service;

import com.simo.dao.entity.auth.UserRole;
import com.simo.dao.repository.authRepository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author simo
 * @Date 2022/12/7 00:51
 * @Version 1.0
 **/

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;


    public List<UserRole> findByUserid(String currentUserId) {
        return userRoleRepository.findByUserid(currentUserId);
    }
}
