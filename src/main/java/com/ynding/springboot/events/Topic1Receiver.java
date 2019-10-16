package com.ynding.springboot.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "queue1")
public class Topic1Receiver {

    @RabbitHandler
    public void handleMessage(String message) {
        log.info("Received Message:<{}>", message);
    }

}
