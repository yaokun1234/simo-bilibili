package com.simo.service;

import com.simo.dao.entity.FollowingGroup;
import com.simo.dao.repository.FollowingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowingGroupService {

    @Autowired
    private FollowingGroupRepository followingGroupRepository;
    
    public FollowingGroup getByType(String type){
        return followingGroupRepository.findByType(type);
    }

    public FollowingGroup getById(String id){
        return followingGroupRepository.getById(id);
    }

    //获取用户的关注分组，包括默认分组
    public List<FollowingGroup> getAllByUserId(String userId) {
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("0");
        typeList.add("1");
        typeList.add("2");
        return followingGroupRepository.findByUserIdOrTypeIn(userId,typeList);
    }

    public void addFollowingGroup(FollowingGroup followingGroup) {
        followingGroupRepository.save(followingGroup);
    }

    //获取用户的关注分组，不包括默认分组
    public List<FollowingGroup> getUserFollowingGroups(String userId) {
        return followingGroupRepository.findByUserId(userId);
    }
}
