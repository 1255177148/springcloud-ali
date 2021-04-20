package com.zhan.springcloud.ali.rocketmq.producer.send;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhan.springcloud.ali.rocketmq.producer.entity.SendModel;
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
        SendModel sendModel = new SendModel();
        sendModel.setCode("200");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhan");
        jsonObject.put("message", "hello");
        sendModel.setData(jsonObject);
        Message message = new Message("test", "tag1", JSON.toJSONString(sendModel).getBytes());
        producer.send(message);
        producer.shutdown();
    }
}
