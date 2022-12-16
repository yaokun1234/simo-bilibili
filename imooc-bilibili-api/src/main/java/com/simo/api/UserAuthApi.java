package com.simo.api;

import com.simo.api.support.UserSupport;
import com.simo.dao.entity.RespBean;
import com.simo.dao.entity.vo.UserAuthoritiesVo;
import com.simo.service.UserAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api( description = "用户权限Api")
public class UserAuthApi {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserSupport userSupport;


    @ApiOperation(value = "获取用户权限")
    @GetMapping("/getUserAuthorities")
    public RespBean getUserAuthorities(){
        String currentUserId = userSupport.getCurrentUserId();
        UserAuthoritiesVo userAuthorities = userAuthService.getUserAuthorities(currentUserId);
        return RespBean.success(userAuthorities);
    }

}
