package com.simo.service.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simo.dao.constant.UserMomentsConstant;
import com.simo.dao.entity.UserFollowing;
import com.simo.dao.entity.UserMoment;
import com.simo.service.UserFollowingService;
import io.netty.util.internal.StringUtil;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserFollowingService userFollowingService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RabbitListener(queuesToDeclare = @Queue(UserMomentsConstant.TOPIC_MOMENTS))
    private void momentsConsumer(String message){
        UserMoment userMoment = JSONObject.toJavaObject(JSONObject.parseObject(message), UserMoment.class);
        String userId = userMoment.getUserId();
        List<UserFollowing> fanList;
        try{
            fanList = userFollowingService.getUserFans(userId);

        }catch (Exception e){
            System.out.println("++++++++++rabbitmq消费者，出现获取粉丝异常");
            return;
        }
        for(UserFollowing fan : fanList){
            String key = "subscribed-" + fan.getUserId();
            String subscribedListStr = redisTemplate.opsForValue().get(key);
            List<UserMoment> subscribedList;
            if(StringUtil.isNullOrEmpty(subscribedListStr)){
                subscribedList = new ArrayList<>();
            }else{
                subscribedList = JSONArray.parseArray(subscribedListStr, UserMoment.class);
            }
            subscribedList.add(userMoment);
            redisTemplate.opsForValue().set(key, JSONObject.toJSONString(subscribedList));
        }
    }
}
