package com.lks.demo.core.mq.springboot.recv;

import com.lks.demo.core.mq.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Slf4j
@RabbitListener(queues = Constant.EXCHANGE_NAME_1,containerFactory = "simpleRabbitListenerContainerFactory")
public class MessageRecvicer {


    @RabbitHandler
    public void process(String message) {
        log.info("接受信息：{}",message);
    }
}
