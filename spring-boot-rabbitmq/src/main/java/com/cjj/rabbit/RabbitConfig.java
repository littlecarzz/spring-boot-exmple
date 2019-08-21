package com.cjj.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 14:50
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
/*      new Queue(name, durable, exclusive, autoDelete);
        name:queueName
        durable:持久化true/false
        exclusive:排他性true/false(只能被单个消费者使用)
        autoDelete：自动删除true/false(队列长时间不使用自动删除)
        */
        return new Queue("hello");
    }
    @Bean
    public Queue queue1() {
        return new Queue("neo");
    }
    @Bean
    public Queue user() {
        return new Queue("user");
    }
}
