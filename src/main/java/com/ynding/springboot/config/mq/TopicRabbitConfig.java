package com.ynding.springboot.config.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TopicRabbitConfig {

    public static final String QUEUE1_NAME = "queue1";
    public static final String QUEUE2_NAME = "queue2";
    public static final String QUEUE3_NAME = "queue3";
    public static final String QUEUE4_NAME = "queue4";
    public static final String EXCHANGE_NAME = "topic-exchange";
    public static final String ROUTING_KEY1 = "usa.news";
    public static final String ROUTING_KEY2 = "usa.*";

    /**
     * 声明队列
     */
    @Bean
    Queue queue1() {
        log.info("queue name:{}", QUEUE1_NAME);
        return new Queue(QUEUE1_NAME, false);
    }
    @Bean
    Queue queue2() {
        log.info("queue name:{}", QUEUE2_NAME);
        return new Queue(QUEUE2_NAME, false);
    }

    /**
     * 声明交换机
     */
    @Bean
    TopicExchange exchange() {
        log.info("exchange:{}", EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 声明绑定规则
     */
    @Bean
    Binding binding1(Queue queue1, TopicExchange exchange) {
        log.info("binding {} to {} with {}", queue1, exchange, QUEUE1_NAME);
        return BindingBuilder.bind(queue1).to(exchange).with(ROUTING_KEY1);
    }
    @Bean
    Binding binding2(Queue queue2, TopicExchange exchange) {
        log.info("binding {} to {} with {}", queue2, exchange, QUEUE2_NAME);
        return BindingBuilder.bind(queue2).to(exchange).with(ROUTING_KEY2);
    }


    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);//必须设置为true，才能让下面的ReturnCallback函数生效

        //消息确认机制
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("=======ConfirmCallback=========");
                log.info("correlationData = " + correlationData);
                log.info("ack = " + ack);//找不到交换机为false
                log.info("cause = " + cause);
                log.info("=======ConfirmCallback=========");
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("--------------ReturnCallback----------------");
                log.info("message = " + message);
                log.info("replyCode = " + replyCode);
                log.info("replyText = " + replyText);
                log.info("exchange = " + exchange);
                log.info("routingKey = " + routingKey);
                log.info("--------------ReturnCallback----------------");
            }
        });

        return rabbitTemplate;
    }

}
