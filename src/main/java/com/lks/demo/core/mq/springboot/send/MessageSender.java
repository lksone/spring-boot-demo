package com.lks.demo.core.mq.springboot.send;

import com.lks.demo.core.mq.config.Constant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  發送
 *
 * @author lks
 * @Time 2020/1/17
 **/
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String messgage){
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        this.rabbitTemplate.convertAndSend(Constant.EXCHANGE_NAME_1,messgage);
    }

}
