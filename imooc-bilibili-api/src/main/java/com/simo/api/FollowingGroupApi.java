package com.simo.api;

import com.simo.dao.repository.FollowingGroupRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "关注分组Api")
@RestController
public class FollowingGroupApi {

    @Autowired
    private FollowingGroupRepository followingGroupRepository;


}
