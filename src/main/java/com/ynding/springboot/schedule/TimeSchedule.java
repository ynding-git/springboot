package com.ynding.springboot.schedule;

import com.ynding.springboot.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@EnableScheduling
@Slf4j
public class TimeSchedule {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    // 可以使用定时器定时发送消息到客户端
    // 实现前台自动刷新时间
//    @Scheduled(fixedDelay = 1000L)
    public void time() {
        log.info("向前台发送时间定时任务启动");
        messagingTemplate.convertAndSend("/topic/time", new Date().toString());
        log.info("向前台发送时间定时任务完成");
    }

//    @Scheduled(cron = "0/20 * * * * ?")
    public void test(){
        System.err.println("*********   定时任务执行   **************");
        CopyOnWriteArraySet<WebSocketServer> webSocketSet =
                WebSocketServer.getWebSocketSet();
        int i = 0 ;
        webSocketSet.forEach(c->{
            try {
                c.sendMessage("  定时发送  " + new Date().toLocaleString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.err.println("/n 定时任务完成.......");
    }


}