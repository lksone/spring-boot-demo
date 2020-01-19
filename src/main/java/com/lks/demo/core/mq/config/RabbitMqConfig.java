package com.lks.demo.core.mq.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 *  创建一个连接指定的rabbitmq的地址
 *
 * @author lks
 * @Time 2020/1/15
 **/
@ComponentScan
@EnableRabbit
@Configuration
@EnableConfigurationProperties(RabbitProperties.class)
public class RabbitMqConfig {

    @Value("${test.rabbitmq.host}")
    private String host;

    @Value("${test.rabbitmq.port}")
    private int port;

    @Value("${test.rabbitmq.username}")
    private String username;

    @Value("${test.rabbitmq.password}")
    private String password;

    @Value("${test.rabbitmq.virtualHost}")
    private String virtualHost;

    /**
     * 创建声明的connectFactory方法
     *
     * @return
     */
    @Bean(value = "connectionFactory")
    @Primary
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        return factory;
    }

    /**
     * 声明监听器
     *
     * @param connectionFactory
     * @return
     */
    @Bean(value = "simpleRabbitListenerContainerFactory")
    @Primary
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(@Qualifier("connectionFactory") ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMaxConcurrentConsumers(5);
        return factory;
    }


    /**
     * 注入的模板
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(@Qualifier("connectionFactory") ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    /**
     * 注入的admin对象
     * @param connectionFactory
     * @return
     */
    @Bean
    @Primary
    public AmqpAdmin amqpAdmin(@Qualifier("connectionFactory") ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }
}
