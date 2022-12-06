package com.simo.service.util;

import com.simo.dao.constant.UserMomentsConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQUtil {

    private static RabbitTemplate rabbitTemplate;


    public static void syncSendMsg(String msg){
        rabbitTemplate.convertAndSend(UserMomentsConstant.TOPIC_MOMENTS,msg);
        System.out.println("发送消息："+msg);
    }

    @Autowired
    public RabbitMQUtil(RabbitTemplate rabbitTemplate) {
        RabbitMQUtil.rabbitTemplate = rabbitTemplate;
    }
//    @PostConstruct
//    public static void init(RabbitTemplate rabbitTemplate){
//
//    }

//    @Autowired
//    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
//        RabbitMQUtil.rabbitTemplate = rabbitTemplate;
//    }
}
