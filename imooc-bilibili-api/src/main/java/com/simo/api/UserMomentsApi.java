package com.simo.api;

import com.simo.api.support.UserSupport;
import com.simo.dao.entity.RespBean;
import com.simo.dao.entity.UserMoment;
import com.simo.service.UserMomentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "用户动态Api")
public class UserMomentsApi {

    @Autowired
    private UserMomentsService userMomentsService;

    @Autowired
    private UserSupport userSupport;

    @PostMapping("/user-moments")
    @ApiOperation("发布动态")
    public RespBean addUserMoments(@RequestBody UserMoment userMoment) throws Exception {
        /**
         * 获取当前用户ID
         * 持久化用户动态
         */
        String currentUserId = userSupport.getCurrentUserId();
        userMoment.setUserId(currentUserId);
        return userMomentsService.addUserMoments(userMoment);

    }

    @ApiOperation("获取订阅的动态")
    @GetMapping("/user-subscribed-moments")
    public RespBean getUserSubscribedMoments(){
        String userId = userSupport.getCurrentUserId();
        return userMomentsService.getUserSubscribedMoments(userId);
    }


}
