package com.zhan.springcloud.ali.rocketmq.consumer.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author elvis
 * @Date 2021/4/20 11:01
 */
public interface MySource {

    String OUTPUT_3 = "output3";

    String OUTPUT_4 = "output4";

    @Output(MySource.OUTPUT_3)
    MessageChannel output3();

    @Output(MySource.OUTPUT_4)
    MessageChannel output4();
}
