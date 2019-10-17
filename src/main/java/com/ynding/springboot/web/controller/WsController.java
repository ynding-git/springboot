package com.ynding.springboot.web.controller;

import com.ynding.springboot.o.bo.ChatResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

/**
 * WebSocket 消息处理类,后台向前台发送消息,实现前后端互动
 *
 */
@RestController
public class WsController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleChat(Principal principal, String msg) {
        String destUser = msg.substring(msg.lastIndexOf(";") + 1, msg.length());
        String message = msg.substring(0, msg.lastIndexOf(";"));
        messagingTemplate.convertAndSendToUser(destUser, "/queue/chat", new ChatResp(message, principal.getName()));
    }

    /**
     * 客户端 调取接口 "/ws/nf": stompClient.send("/app/ws/time", {}, JSON.stringify({ 'name': name }));
     * 处理信息之后，服务端向监听"topic/time"的客户端页面发送消息。
     * 类似于前后端不分离时的回调函数，只不过调取服务端接口，和接受服务端信息的不一定是同一个“对象”
     */
    @MessageMapping("/ws/time")
    @SendTo("/topic/time")
    public String handleTime(String message) {
        //我们使用这个方法进行消息的转发发送！
        //this.simpMessagingTemplate.convertAndSend("/topic/time", value);
        //也可以使用sendTo发送
        return new Date().toString();
    }

}