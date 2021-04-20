package com.zhan.springcloud.ali.rocketmq.producer.send;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

/**
 * @Author elvis
 * @Date 2021/4/20 12:01
 */
@Component
public class RocketMQProducer {

    public void output1() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        Message message = new Message("test", "tag1", "hello".getBytes());
        producer.send(message);
        producer.shutdown();
    }
}
