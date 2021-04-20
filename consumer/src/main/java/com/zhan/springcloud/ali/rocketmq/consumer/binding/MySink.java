package com.zhan.springcloud.ali.rocketmq.consumer.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author elvis
 * @Date 2021/4/20 11:06
 */
public interface MySink {

    String INPUT_3 = "input3";

    String INPUT_4 = "input4";

    @Input(MySink.INPUT_3)
    SubscribableChannel input3();

    @Input(MySink.INPUT_4)
    SubscribableChannel input4();
}
