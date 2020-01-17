package com.lks.demo.core.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建一个queue
 *
 *
 * @author lks
 * @Time 2020/1/15
 **/
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("q-hello");
    }
}
