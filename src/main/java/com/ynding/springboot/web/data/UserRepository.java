package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>,QuerydslPredicateExecutor<User> {

    User findUserByUsername(String username);
}
