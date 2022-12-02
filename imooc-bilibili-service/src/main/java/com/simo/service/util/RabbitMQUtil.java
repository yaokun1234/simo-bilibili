package com.simo.service.util;

import com.simo.dao.constant.UserMomentsConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQUtil {

    @Autowired
    private static RabbitTemplate rabbitTemplate;

    public static void syncSendMsg(String msg){
        rabbitTemplate.convertAndSend(UserMomentsConstant.TOPIC_MOMENTS,msg);
        System.out.println("发送消息："+msg);
    }
}
