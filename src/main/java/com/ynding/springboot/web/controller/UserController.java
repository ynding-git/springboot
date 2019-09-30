package com.ynding.springboot.web.controller;

import com.ynding.springboot.entity.Book;
import com.ynding.springboot.entity.User;
import com.ynding.springboot.o.bo.GQuery;
import com.ynding.springboot.o.bo.ResponseBean;
import com.ynding.springboot.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value="User",tags={"User-Controller"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "查询列表", produces = "application/json")
    public ResponseBean findList(@RequestParam Map<String, Object> params){

        GQuery query = new GQuery(params);
        List<User> users = userService.findList(query);

        return ResponseBean.ok(users);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", produces = "application/json")
    public ResponseBean pageList(@RequestParam Map<String, Object> params){
        GQuery query = new GQuery(params);
        Page<User> users = userService.pageList(query);

        return ResponseBean.ok(users);
    }
}
