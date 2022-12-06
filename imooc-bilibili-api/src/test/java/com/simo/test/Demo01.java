package com.simo.test;

import com.simo.ImoocBilibiliApp;
import com.simo.dao.entity.auth.AuthRoleElementOperation;
import com.simo.dao.repository.authRepository.AuthRoleElementOperationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ImoocBilibiliApp.class)
public class Demo01 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AuthRoleElementOperationRepository authRoleElementOperationRepository;

    @Test
    public void test01() {

        List<AuthRoleElementOperation> all = authRoleElementOperationRepository.findAll();
        System.out.println(all);
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
