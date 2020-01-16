package com.lks.demo.core.mq.subscribe.consumer;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 *
 * 订阅模式的消费者
 *
 * @author lks
 * @Time 2020/1/16
 **/
public class MessageConsumer {

    /**
     *
     */
    private final static String QUEUE_NAME = "test_queue_work1";

    /**
     * 交换队列
     */
    private final static String EXCHANGE_NAME = "exchange_demo";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 声明队列
         *
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        /**
         * 绑定队列到交换机
         * 隊列名稱
         * 交換機
         */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        /**
         *  监听队列，手动返回完成
         */
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
