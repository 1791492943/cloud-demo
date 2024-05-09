package com.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/seed/queue")
    public void testSimpleQueue(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }

    @GetMapping("/seed/exchange")
    public void testSimpleExchange(String exchange, String message) {
        rabbitTemplate.convertAndSend(exchange, null, message);
    }

}
