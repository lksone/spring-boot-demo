package com.lks.demo.core.mq.springboot.recv;

import com.lks.demo.core.mq.config.Constant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 *
 * @author lks
 * @Time 2020/1/17
 **/
@Component
@RabbitListener(queues = Constant.EXCHANGE_NAME_1)
public class MessageRecvicer {

    @RabbitHandler
    public void process(String message) {
        System.out.println("reciver---:" + message);
    }
}
