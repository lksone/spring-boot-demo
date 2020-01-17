package com.lks.demo.core.mq.topic.consumer;

import com.lks.demo.core.mq.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author lks
 * @Time 2020/1/17
 **/
public class TopicMessageConsumer1 {

    private static final String EXCHANGE_NAME = "exchange_topic";

    private static final String QUEUE_NAME = "topic_queue_test1";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        //聲明隊列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /**
         * 綁定交換機
         *
         * 注意點：該匹配需要通過 .去区分*；
         * 例如：roututungkey* 是不能够被区分和匹配的
         *      roututungkey.* 是可以匹配到指定的数据
         *
         */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "routingkey.*");

        channel.basicQos(1);

        //獲取消費者對象
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, queueingConsumer);
        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();

            String string = new String(delivery.getBody());

            System.out.println(string);

            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }

    }
}
