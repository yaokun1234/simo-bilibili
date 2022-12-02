package com.simo.service.config;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloCustomer {

    @RabbitListener(queuesToDeclare = @Queue(name = "hello"))
    public void receive1(String message) {

        System.out.println("+++++++++message1:"+message);
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "hello"))
    public void receive2(String message) {

        System.out.println("+++++++++message2:"+message);
    }

}
