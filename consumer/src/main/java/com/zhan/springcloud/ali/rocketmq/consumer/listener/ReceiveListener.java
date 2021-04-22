package com.zhan.springcloud.ali.rocketmq.consumer.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Author elvis
 * @Date 2021/4/20 12:45
 * 这里使用的是spring cloud ali官方提供的spring cloud stream集成rocketMQ的方法
 */
@Component
public class ReceiveListener {

    @StreamListener("input3")
    public void input3(String message){
        System.out.println("input3收到的消息是：" + message);
    }

    @StreamListener("input4")
    public void input4(String message){
        System.out.println("input4收到的消息是：" + message);
    }
}
