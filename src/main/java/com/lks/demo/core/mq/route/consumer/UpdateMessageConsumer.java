package com.lks.demo.core.mq.route.consumer;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author lks
 * @Time 2020/1/16
 **/
public class UpdateMessageConsumer {

    /**
     * 指定的隊列名称
     */
    private static final String QUEUE_NAME= "test_queue_dircet1";

    /**
     * 指定的exchange的name
     */
    private static final String EXCHANGE_NAME = "dirct_exchange_demo";

    public static void main(String[] args) throws Exception {

        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();

        //2.创建连接通道
        Channel channel = connection.createChannel();

        //3.声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //4.绑定到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"update");

        //5.统一时刻服务器只会有一条消息给消费者
        channel.basicQos(1);

        //6.定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAME, false, queueingConsumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
