package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    /**
     * Use such uncommented code for Consumer Service
     */
//    private Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);
//
//    @RabbitListener(queues = "myQueue1")
//    public void processMyQueue1(String message){
//        logger.info("Received from myQueue1 by first listener: {}", message);
//    }
//
//    @RabbitListener(queues = "myQueue2")
//    public void processMyQueue2(String message){
//        logger.info("Received from myQueue2 by second listener: {}", message);
//    }
//
//    @RabbitListener(queues = "myQueue3")
//    public void processMyQueue3(String message){
//        logger.info("Received from myQueue3 by third listener: {}", message);
//    }
}
