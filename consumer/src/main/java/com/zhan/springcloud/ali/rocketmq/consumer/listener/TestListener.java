package com.zhan.springcloud.ali.rocketmq.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author elvis
 * @Date 2021/4/21 15:37
 * 这里是不用springCloud ali 官方提供的spring cloud stream集成rocketMQ的方法，
 * 而是直接使用普通springboot项目集成rocketMQ的方法，感觉配置更少(只是感觉)
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "test", selectorType = SelectorType.TAG,selectorExpression="tag2",consumerGroup = "test-group")
public class TestListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("onMessage收到的消息是：" + message);
    }
}
