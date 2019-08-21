package com.cjj.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 15:52
 */
@Configuration
public class TopicRabbitConfig {
    private final static String message = "topic.message";
    private final static String messages = "topic.messages";
    @Bean
    public Queue messageQueue() {
        return new Queue(TopicRabbitConfig.message);
    }
    @Bean
    public Queue messagesQueue() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange ("topicExchange");
    }

    @Bean
    public Binding bindingExchangeMessage(Queue messageQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messageQueue).to(exchange).with("topic.message");
    }
    @Bean
    public Binding bindingExchangeMessages(Queue messagesQueue, TopicExchange exchange) {
        return BindingBuilder.bind(messagesQueue).to(exchange).with("topic.#");
    }
}
