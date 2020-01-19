package com.lks.demo.core.mq.base;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 發送通知抽象
 *
 * @author lks
 * @Time 2020/1/19
 **/
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate template;

    /**
     * 一对一模式发送
     *
     * @param queueName
     * @param message
     */
    public void send(String queueName,String message){
        this.template.convertAndSend(queueName,message);
    }

    /**
     * 死信隊列，通過吸限制過期時間進入
     *
     * 死信隊列中
     * @param exchangeName      交換機
     * @param routingKey        路由key
     * @param content           內容
     * @param time              過期時間
     */
    public void sendByFount(String exchangeName,String routingKey,Object content,String time){
        //
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setContentEncoding("utf-8");
            messageProperties.setExpiration(time);
            return message;
        };
        this.template.convertAndSend(exchangeName,routingKey,content,messagePostProcessor);
    }
}
