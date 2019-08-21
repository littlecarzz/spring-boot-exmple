package com.cjj.rabbit.object;

import com.cjj.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 15:40
 */
@Component
public class UserSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println("Send Object:" + user.toString());
        rabbitTemplate.convertAndSend("user",user);
    }
}
