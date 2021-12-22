package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    private Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "myQueue")
    public void processMyQueue(String message){
        logger.info("Received from myQueue: {}", message);
    }
}
