package com.simo.test;

import com.simo.ImoocBilibiliApp;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImoocBilibiliApp.class)
public class Demo01 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test01() {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("hello","hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void test02() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("logs","","hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test03() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("logs","","hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
