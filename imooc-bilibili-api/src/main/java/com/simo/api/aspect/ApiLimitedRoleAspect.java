package com.simo.api.aspect;

import com.simo.api.support.UserSupport;
import com.simo.dao.annotation.ApiLimitedRole;
import com.simo.dao.entity.auth.UserRole;
import com.simo.dao.exception.ConditionException;
import com.simo.service.UserRoleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author simo
 * @Date 2022/12/7 00:39
 * @Version 1.0
 **/
@Aspect
@Component
@Order(1)
public class ApiLimitedRoleAspect {

    @Autowired
    private UserSupport userSupport;
//
    @Autowired
    private UserRoleService userRoleService;
    @Pointcut("@annotation(com.simo.dao.annotation.ApiLimitedRole)")
    public void check(){};

    @Before("check() && @annotation(apiLimitedRole)")
    public void doBefore(JoinPoint joinPoint, ApiLimitedRole apiLimitedRole){
        String currentUserId = userSupport.getCurrentUserId();
        List<UserRole> userRoles = userRoleService.findByUserid(currentUserId);
        Set<String> roleCodes = userRoles.stream().map(userRole -> userRole.getAuthRole().getCode()).collect(Collectors.toSet());
        Set<String> limitedRoleCodes = Arrays.stream(apiLimitedRole.limitedRoleCodeList()).collect(Collectors.toSet());
        roleCodes.retainAll(limitedRoleCodes);
        if(roleCodes.size() > 0){
            throw new ConditionException("该用户权限不足");
        }
    }

}
