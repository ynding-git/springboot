package com.ynding.springboot.web.controller;

import com.ynding.springboot.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@Slf4j
@RestController
@Api(value="Hello",tags={"首页控制器"})
public class HelloController {

    @ApiOperation(value="", produces = "application/json")
    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @ApiOperation(value="hello", produces = "application/json")
    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView m){
    	 m.addObject("now", DateFormat.getDateTimeInstance().format(new Date()));
    	 m.setViewName("hello");
        try {
            WebSocketServer.sendInfo("dd","20");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }

}