package com.cjj.rabbit.hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 14:56
 */
@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "hello" + new Date();
        System.out.println("Sender:" + message);
        rabbitTemplate.convertAndSend("hello",message);

    }
}
