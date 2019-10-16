package com.ynding.springboot.events;

import io.swagger.annotations.Api;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ynding.springboot.config.mq.TopicRabbitConfig.EXCHANGE_NAME;

@RestController
@Api(value="RabbitSendController",tags={"消息发送"})
@RequestMapping("/rabbit")
public class RabbitSendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendTopic1")
    public String sendTopic1(String message){
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,"usa.news",message);
        return "OK,sendTopicFirst:" + message;
    }

    @GetMapping("/sendTopic2")
    private String sendTopic2(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "usa.weather", message);
        return "OK,sendTopicSecond:" + message;
    }
}
