package com.lks.demo.core.mq.subscribe.product;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 *
 * 订阅模式的生产者（）
 *
 *  一个生产者和多个消费者多条队列
 *  1、1个生产者，多个消费者
 * 2、每一个消费者都有自己的一个队列
 * 3、生产者没有将消息直接发送到队列，而是发送到了交换机
 * 4、每个队列都要绑定到交换机
 * 5、生产者发送的消息，经过交换机，到达队列，实现，一个消息被多个消费者获取的目的
 * 注意：一个消费者队列可以有多个消费者实例，只有其中一个消费者实例会消费
 * @author lks
 * @Time 2020/1/16
 **/
public class MessageProducer {

    /**
     * 交换机名称
     */
    private final static String EXCHANGE_NAME = "exchange_demo";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        /**
         *
         * 交换器类型 DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers");
         */
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "Hello World!";
        /**
         * 發送消息
         */
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
