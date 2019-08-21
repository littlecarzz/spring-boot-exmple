package com.cjj.rabbit.object;

import com.cjj.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 15:42
 */
@Component
@RabbitListener(queues = "user")
public class UserReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver Object:"+user.toString());
    }
}
