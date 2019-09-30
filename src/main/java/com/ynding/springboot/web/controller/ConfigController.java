package com.ynding.springboot.web.controller;

import cn.hutool.core.util.ArrayUtil;
import com.ynding.springboot.common.UserUtils;
import com.ynding.springboot.entity.Menu;
import com.ynding.springboot.entity.Role;
import com.ynding.springboot.entity.User;
import com.ynding.springboot.web.data.MenuRepository;
import com.ynding.springboot.web.data.UserRepository;
import com.ynding.springboot.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ArrayUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    MenuRepository menuRepository;


    @GetMapping("/sysMenu")
    public List<Menu> sysMenu() {

        return menuRepository.findAll();
    }

    @GetMapping("/user")
    public User currentUser() {
        return UserUtils.getCurrentUser();
    }
}
