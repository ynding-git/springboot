package com.ynding.springboot.web.controller;

import com.ynding.springboot.common.utils.Md5Util;
import com.ynding.springboot.entity.User;
import com.ynding.springboot.o.bo.ResponseBean;
import com.ynding.springboot.web.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(value = "RegLogin", tags = {"登录注册-Controller"})
public class RegLoginController {

    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    AuthenticationManager authenticationManager;
    String tokenHead = "Bearer ";

    @RequestMapping("/login_p")
    public ModelAndView login(ModelAndView m) {

        m.setViewName("login_p");
        return m;
    }

    @PostMapping("/login")
    public ResponseBean refreshAndGetAuthenticationToken(
            @RequestBody User user) throws AuthenticationException {

        String username = user.getUsername();
        String password = user.getPassword();
        return ResponseBean.ok(generateToken(username, password));
    }


    /**
     * 登陆与授权.
     *
     * @param username .
     * @param password .
     * @return
     */
    private String generateToken(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userService.loadUserByUsername(username);
        // 持久化的redis
        String token = tokenHead + Md5Util.stringToMD5(userDetails.getUsername());
        redisTemplate.opsForValue().set(token, userDetails.getUsername());
        return token;
    }


}
