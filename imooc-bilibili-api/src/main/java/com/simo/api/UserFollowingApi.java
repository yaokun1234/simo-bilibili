package com.simo.api;

import com.simo.api.support.UserSupport;
import com.simo.dao.entity.FollowingGroup;
import com.simo.dao.entity.RespBean;
import com.simo.dao.entity.UserFollowing;
import com.simo.service.UserFollowingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "用户关注接口")
public class UserFollowingApi {
    @Autowired
    private UserFollowingService userFollowingService;

    @Autowired
    private UserSupport userSupport;

    @PostMapping("/user-followings")
    @ApiOperation("添加关注")
    public RespBean addUserFollowings(@RequestBody UserFollowing userFollowing){
        String userId = userSupport.getCurrentUserId();
        userFollowing.setUserId(userId);
        userFollowingService.addUserFollowing(userFollowing);
        return RespBean.success();
    }

    @GetMapping("/user-followings")
    @ApiOperation("获取关注列表")
    public RespBean getUserFollowings(){
        String userId = userSupport.getCurrentUserId();
        List<FollowingGroup> result = userFollowingService.getUserFollowings(userId);
        return RespBean.success(result);
    }

    @GetMapping("/user-fans")
    @ApiOperation("获取粉丝列表")
    public RespBean getUserFans(){
        String userId = userSupport.getCurrentUserId();
        List<UserFollowing> result = userFollowingService.getUserFans(userId);
        return RespBean.success(result);
    }
}
