package com.zhan.springcloud.ali.rocketmq.producer.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author elvis
 * @Date 2021/4/20 11:06
 */
public interface MySink {

    String INPUT_1 = "input1";

    String INPUT_2 = "input2";

    @Input(MySink.INPUT_1)
    SubscribableChannel input1();

    @Input(MySink.INPUT_2)
    SubscribableChannel input2();
}
