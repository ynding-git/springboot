package com.ynding.springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {

        String password = "123456";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String p = encoder.encode(password);

        System.out.println(p);

    }
}
