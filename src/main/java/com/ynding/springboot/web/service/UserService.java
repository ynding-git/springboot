package com.ynding.springboot.web.service;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.ynding.springboot.entity.QUser;
import com.ynding.springboot.entity.User;
import com.ynding.springboot.o.bo.GQuery;
import com.ynding.springboot.o.bo.ResponseBean;
import com.ynding.springboot.web.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ynding.springboot.o.bo.ResponseCode.USER_AlREAD_EXIST_EXCEPTION;

@Service
@Transactional(readOnly = true)
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
    @Transactional(readOnly = false)
    public ResponseBean userReg(String username, String password) {
        //如果用户名存在，返回错误
        if (userRepository.findUserByUsername(username) != null) {
            return ResponseBean.fail(USER_AlREAD_EXIST_EXCEPTION);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encode);
        return ResponseBean.ok(userRepository.save(user));
    }


    /**
     * 查询用户列表
     * @param query
     * @return
     */
    public List<User> findList(GQuery query) {

        return (List<User>) userRepository.findAll(predicate(query));
    }

    /**
     * 分页查询
     * @param query
     * @return
     */
    public Page<User> pageList(GQuery query) {

        Pageable pageable =  PageRequest.of(query.getOffset(), query.getLimit(), Sort.Direction.DESC, "id");
        return userRepository.findAll(predicate(query),pageable);
    }


    /**
     * 断言
     * @param query
     * @return
     */
    private Predicate predicate(GQuery query){
        QUser user = QUser.user;
        //初始化组装条件(类似where 1=1)
        Predicate predicate = user.isNotNull().or(user.isNull());
        if(query.get("username") != null)
            predicate = ExpressionUtils.and(predicate,user.username.eq((String) query.get("username")));
        if(query.get("phone") != null)
            predicate = ExpressionUtils.and(predicate,user.username.eq((String) query.get("phone")));
        if(query.get("name") != null)
            predicate = ExpressionUtils.and(predicate,user.name.like((String) query.get("name")));
        if(query.get("address") != null)
            predicate = ExpressionUtils.and(predicate,user.name.like((String) query.get("address")));

        return predicate;
    }

}
