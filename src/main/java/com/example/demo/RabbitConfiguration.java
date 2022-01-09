package com.example.demo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue myQueue1(){
        return new Queue("myQueue1");
    }

    @Bean
    public Queue myQueue2(){
        return new Queue("myQueue2");
    }

    @Bean
    public Queue myQueue3(){
        return new Queue("myQueue3");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(topicExchange()).with("error.*");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("*.warning");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(myQueue3()).to(topicExchange()).with("info.*");
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
