package com.lks.demo.core.mq.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author lks
 * @Time 2020/1/15
 **/
public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("c1_test");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
