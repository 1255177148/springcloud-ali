package com.zhan.springcloud.ali.rocketmq.producer.controller;

import com.zhan.springcloud.ali.rocketmq.producer.send.RocketMQProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author elvis
 * @Date 2021/4/20 12:48
 */
@RestController
@RequestMapping("/api/send")
public class TestSendController {

    @Resource
    private RocketMQProducer rocketMQProducer;

    @GetMapping
    public void send() throws Exception {
        rocketMQProducer.output1();
    }
}
