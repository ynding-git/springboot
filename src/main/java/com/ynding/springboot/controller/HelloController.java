package com.ynding.springboot.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;

@Slf4j
@RestController
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
    	return m;
    }
 
}