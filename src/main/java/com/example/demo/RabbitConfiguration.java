package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);


    @Bean
    public ConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1(){
        return new Queue("myQueue1");
    }

    @Bean
    public Queue myQueue2(){
        return new Queue("myQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("common-exchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(fanoutExchange());
    }

    /*
        Use RabbitMqListener instead this Bean
     */
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames("myQueue");
//        container.setMessageListener(message -> logger.info("Received from myQueue : " + new String(message.getBody())));
//        return container;
//    }
}
