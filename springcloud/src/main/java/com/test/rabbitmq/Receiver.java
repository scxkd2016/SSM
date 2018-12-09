package com.test.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "hello-queue")
    public void process(String msg) {
        System.out.println("receiver: "+msg);
    }
}
