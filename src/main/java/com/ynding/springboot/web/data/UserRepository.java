package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findHrByUsername(String username);
}
