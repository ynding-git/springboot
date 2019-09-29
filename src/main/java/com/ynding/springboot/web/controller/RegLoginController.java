package com.ynding.springboot.web.controller;

import com.ynding.springboot.o.bo.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegLoginController {

    @RequestMapping("/login_p")
    public ResponseBean login() {

        return ResponseBean.fail("尚未登录，请登录!");
    }

    @GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }
}
