package com.demo.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitListenerConsume {

    @RabbitListener(bindings = @QueueBinding(value = @Queue("simple-queue"), exchange = @Exchange("simple-exchange")))
    public void consume(String message) {
        System.out.println("Consume1 message: " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("simple-queue2"), exchange = @Exchange("simple-exchange")))
    public void consume2(String message) {
        System.out.println("Consume2 message: " + message);
    }

}
