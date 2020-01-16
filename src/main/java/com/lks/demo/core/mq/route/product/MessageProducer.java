package com.lks.demo.core.mq.route.product;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 *
 * 路由方式
 *
 * @author lks
 * @Time 2020/1/16
 **/
public class MessageProducer {

    private static final String EXCHANGE_NAME="dirct_exchange_demo";

    public static void main(String[] args) throws Exception {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.声明exchange，direct可以指定rounting key值
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String message = "delete,你是哪个？？";
        //设置路由routingkey的key值
        channel.basicPublish(EXCHANGE_NAME,"delete",null,message.getBytes());


        // 发送info路由键消息
        String infoMessage = "update,hello, update";
        channel.basicPublish(EXCHANGE_NAME, "update", null, infoMessage.getBytes());
        System.out.println(" [x] Sent routing info message : '" + infoMessage + "'");
        channel.close();
        connection.close();
    }
}
