package com.example.productservice.publisher;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ProductPublisher {

    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue queue2;
    @Autowired
    DirectExchange directExchange;

    public String demoPub() {
        String messQueue = "messQueue";
        String messEx = "messExchange";
//        rabbitTemplate.convertAndSend(queue2.getName(), messQueue);
//        return "success";
        var result = rabbitTemplate.convertSendAndReceive(directExchange.getName(), "direct.routing.key", messEx);
        return (String) result;
    }

}
