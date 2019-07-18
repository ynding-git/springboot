package com.ynding.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@Slf4j
@RestController
public class HelloController {
 
    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }
    
    @RequestMapping("/hello")
    public Model hello(Model m){
    	 m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
    	return m;
    }
 
}