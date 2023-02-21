package com.example.productservice.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProductConsumer {

    @RabbitListener(queues = "queue1")
    String demo(String message) {
        System.out.println("Message read from queue1 : " +message);
        return message;
    }

    @RabbitListener(queues = "queue2")
    public String listen(String in) {
        System.out.println("Message read from queue2 : " + in);
        return in;
    }
}
