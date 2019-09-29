package com.ynding.springboot.web.service;

import com.ynding.springboot.entity.User;
import com.ynding.springboot.exception.CException;
import com.ynding.springboot.web.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ynding.springboot.exception.ExceptionEnum.USER_AlREAD_EXIST_EXCEPTION;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public User userReg(String username, String password) throws CException{
        //如果用户名存在，返回错误
        if (userRepository.findUserByUsername(username) != null) {
            throw new CException(USER_AlREAD_EXIST_EXCEPTION);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encode);
        return userRepository.save(user);
    }


}
