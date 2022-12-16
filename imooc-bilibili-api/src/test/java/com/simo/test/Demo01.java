package com.simo.test;

import com.simo.ImoocBilibiliApp;
import com.simo.dao.repository.authRepository.AuthRoleElementOperationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ImoocBilibiliApp.class)
public class Demo01 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AuthRoleElementOperationRepository authRoleElementOperationRepository;

    @Test
    public void test01() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
//        list1.add("a");
        list1.add("b");
        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        System.out.println(list1.containsAll(list));
//        System.out.println(list1);
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
