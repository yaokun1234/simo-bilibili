package com.simo.service;

import com.alibaba.fastjson.JSONObject;
import com.simo.dao.entity.RespBean;
import com.simo.dao.entity.UserMoment;
import com.simo.dao.repository.UserFollowingRepository;
import com.simo.dao.repository.UserMomentsRepository;
import com.simo.service.util.RabbitMQUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMomentsService {

    @Autowired
    private UserMomentsRepository userMomentsRepository;

    @Autowired
    private UserFollowingRepository userFollowingRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public RespBean addUserMoments(UserMoment userMoment) {
        userMomentsRepository.save(userMoment);
        String mes = JSONObject.toJSONString(userMoment);
        RabbitMQUtil.syncSendMsg(mes);
        return RespBean.success("发布动态成功");

    }

    public RespBean getUserSubscribedMoments(String userId) {
//        List<UserFollowing> allByUserId = userFollowingRepository.findAllByUserId(userId);
//        List<String> FollowingIdList = allByUserId.stream().map(UserFollowing::getFollowingId).collect(Collectors.toList());
//        List<UserMoment> userMomentList = userMomentsRepository.findAllByUserIdIn(FollowingIdList);


        String subscribedMomentsJson = redisTemplate.opsForValue().get("subscribed-" + userId);
        List<UserMoment> userMomentList = JSONObject.parseArray(subscribedMomentsJson, UserMoment.class);
        return RespBean.success(userMomentList);
    }
}
