package com.simo.service;

import com.simo.dao.constant.UserInfoConstant;
import com.simo.dao.entity.FollowingGroup;
import com.simo.dao.entity.User;
import com.simo.dao.entity.UserFollowing;
import com.simo.dao.entity.UserInfo;
import com.simo.dao.exception.ConditionException;
import com.simo.dao.repository.UserFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserFollowingService {

    @Autowired
    private UserFollowingRepository userFollowingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FollowingGroupService followingGroupService;

    @Autowired
    private UserInfoService userInfoService;


    @Transactional(rollbackFor = Exception.class)
    public void addUserFollowing(UserFollowing userFollowing){
        User dbUser = userService.getById(userFollowing.getFollowingId());
        if (dbUser == null) {
            throw new ConditionException("关注用户不存在");
        }
        FollowingGroup dbFollowingGroup = followingGroupService.getById(userFollowing.getGroupId());
        if (dbFollowingGroup == null) {
            throw new ConditionException("关注分组不存在");
        }
        userFollowingRepository.deleteByUserIdAndFollowingId(userFollowing.getUserId(),userFollowing.getFollowingId());
        userFollowing.setCreateTime(new Date());
        userFollowing.setId(UUID.randomUUID().toString());
        userFollowingRepository.save(userFollowing);
    }

    // 第一步：获取关注的用户列表
    // 第二步：根据关注用户的id查询关注用户的基本信息
    // 第三步：将关注用户按关注分组进行分类
    public List<FollowingGroup> getUserFollowings(String userId){
        List<UserFollowing> userFollowingList = userFollowingRepository.findAllByUserId(userId);
        ArrayList<UserInfo> userInfos = new ArrayList<>();
        userFollowingList.stream().peek(e -> {
            UserInfo userInfo = userInfoService.getUserInfo(e.getFollowingId()).getUserInfo();
            userInfos.add(userInfo);
            e.setUserInfo(userInfo);
        }).collect(Collectors.toList());
        FollowingGroup allFollowing = new FollowingGroup();
        allFollowing.setName(UserInfoConstant.USER_FOLLOWING_GROUP_ALL_NAME);
        allFollowing.setFollowingUserInfoList(userInfos);
        ArrayList<FollowingGroup> result = new ArrayList<>();
        result.add(allFollowing);
        List<FollowingGroup> allByUserId = followingGroupService.getAllByUserId(userId);
        for (FollowingGroup followingGroup : allByUserId) {
            ArrayList<UserInfo> infos = new ArrayList<>();
            userFollowingList.stream().peek(e ->{
                if(e.getGroupId().equals(followingGroup.getId())){
                    infos.add(e.getUserInfo());
                }
            }).collect(Collectors.toList());
        }
        return result;

    }

    // 第一步：获取当前用户的粉丝列表
    // 第二步：根据粉丝的用户id查询基本信息
    // 第三步：查询当前用户是否已经关注该粉丝
    public List<UserFollowing> getUserFans(String userId) {
        List<UserFollowing> userFollowingList = userFollowingRepository.findAllByFollowingId(userId);
        userFollowingList.stream().peek(e -> {
            UserInfo userInfo = userInfoService.getUserInfo(e.getUserId()).getUserInfo();
            boolean exists = userFollowingRepository.existsByUserIdAndFollowingId(userId, e.getUserId());
            userInfo.setFollowed(exists);
            e.setUserInfo(userInfo);
        }).collect(Collectors.toList());
        return userFollowingList;
    }


}
