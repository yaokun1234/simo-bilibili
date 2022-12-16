package com.simo.service;

import com.simo.dao.constant.AuthRoleConstant;
import com.simo.dao.entity.auth.AuthRole;
import com.simo.dao.entity.auth.AuthRoleElementOperation;
import com.simo.dao.entity.auth.AuthRoleMenu;
import com.simo.dao.entity.auth.UserRole;
import com.simo.dao.entity.vo.UserAuthoritiesVo;
import com.simo.dao.repository.authRepository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AuthRoleElementOperationService authRoleElementOperationService;

    @Autowired
    private AuthRoleMenuService authRoleMenuService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private AuthRoleService authRoleService;



    /**
     * @Author simo
     * @Description 获取用户权限信息
     * @Date 11:47 2022/12/6
     * @Param [currentUserId]
     * @return com.simo.dao.entity.vo.UserAuthorities
     **/
    public UserAuthoritiesVo getUserAuthorities(String currentUserId) {

        List<UserRole> userRoles = userRoleService.findByUserid(currentUserId);
        List<String> roleIds = userRoles.stream().map(userRole -> userRole.getAuthRole().getId()).collect(Collectors.toList());
        List<AuthRoleElementOperation> elementOperations = authRoleElementOperationService.findByRoleidIn(roleIds);
        List<AuthRoleMenu> menus = authRoleMenuService.findByRoleidIn(roleIds);
        UserAuthoritiesVo userAuthoritiesVo = new UserAuthoritiesVo();
        userAuthoritiesVo.setAuthRoleMenus(menus);
        userAuthoritiesVo.setElementOperations(elementOperations);
        return userAuthoritiesVo;
    }

    public void addUserDefaultAuth(String userId) {

        AuthRole authRole = authRoleService.findByRoleCode(AuthRoleConstant.ROLE_LV0);
        UserRole userRole = new UserRole();
        userRole.setUserid(userId);
        userRole.setAuthRole(authRole);
        userRoleRepository.save(userRole);
    }
}
