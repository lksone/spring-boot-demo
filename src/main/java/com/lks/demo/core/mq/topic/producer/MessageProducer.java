package com.lks.demo.core.mq.topic.producer;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 主题的消费模式（通配符的方式进行发送）
 *
 * @author lks
 * @Time 2020/1/16
 **/
public class MessageProducer {

    private static final String EXCHANGE_NAME = "exchange_topic";

    public static void main(String[] args) throws Exception {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();

        //2.獲取
        Channel channel = connection.createChannel();

        //3.申明
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        //消息
        String message = "hello world";

        channel.basicPublish(EXCHANGE_NAME, "routingkey.123", null, message.getBytes());

        channel.close();

        connection.close();
    }
}
