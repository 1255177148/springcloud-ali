package com.zhan.springcloud.ali.rocketmq.producer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author elvis
 * @Date 2021/4/20 17:35
 */
@Data
public class SendModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private Object data;
    private String message;
}
