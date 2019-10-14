package com.ynding.springboot;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestStream {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        System.out.println(Integer.MAX_VALUE);
        for(int i = 0 ;i < 100000; i++){
            ints.add(i);
        }

        long start = System.currentTimeMillis();
        log.info("start: " + start);
        ints = ints.stream().filter(p -> p > 100).limit(10).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        log.info("use time : " + (end - start));

        for(int i : ints){
//            System.out.println(i);
        }
    }
}
