package com.ynding.springboot.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "queue2")
public class Topic2Receiver {
    @RabbitHandler
    public void handleMessage(String message) {
        log.info("Received Message:<{}>", message);
    }
}
