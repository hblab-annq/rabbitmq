package com.example.productservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {

    static final String topic_exchange = "topicExchange1";
    static final String direct_exchange = "directExchange1";
    static final String headers_exchange = "headersExchange1";
    static final String fanout_exchange = "fanoutExchange1";

    static final String queue1 = "queue1";
    static final String queue2 = "queue2";
    static final String queue3 = "queue3";
    static final String queue4 = "queue4";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topic_exchange, false, true);
    }
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(headers_exchange, false, true);
    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(direct_exchange, false, true);
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanout_exchange, false, true);
    }

    @Bean
    public Queue queue1() {
        return new Queue(queue1, false, false, true);
    }
    @Bean
    public Queue queue2() {
        return new Queue(queue2, false, false, true);
    }
    @Bean
    public Queue queue3() {
        return new Queue(queue3, false, false, true);
    }
    @Bean
    public Queue queue4() {
        return new Queue(queue4, false, false, true);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("topic.routing.key");
    }

    // Create the binding for queue 2 to the direct exchange
    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("direct.routing.key");
    }

    // Create the binding for queue 1 to the header exchange
    @Bean
    public Binding headerBinding1() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        return BindingBuilder.bind(queue1()).to(headersExchange()).whereAll(headers).match();
    }

    // Create the binding for queue 2 to the fanout exchange
    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
}
