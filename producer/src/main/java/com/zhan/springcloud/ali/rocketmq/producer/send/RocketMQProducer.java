package com.zhan.springcloud.ali.rocketmq.producer.send;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhan.springcloud.ali.rocketmq.producer.entity.SendModel;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author elvis
 * @Date 2021/4/20 12:01
 */
@Component
public class RocketMQProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 使用RocketMQ原生API生产消息
     * @throws Exception
     */
    public void output1() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        SendModel sendModel = build();
        Message message = new Message("test", "tag2", JSON.toJSONString(sendModel).getBytes());
        producer.send(message);
        producer.shutdown();
    }

    /**
     * 使用RocketMQTemplate进行一次普通的消息发送
     */
    public void send(){
        SendModel sendModel = build();
        rocketMQTemplate.convertAndSend("test:tag1", sendModel);
    }

    private SendModel build(){
        SendModel sendModel = new SendModel();
        sendModel.setCode("200");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhan");
        jsonObject.put("message", "hello");
        jsonObject.put("date", format.format(new Date()));
        sendModel.setData(jsonObject);
        return sendModel;
    }
}
