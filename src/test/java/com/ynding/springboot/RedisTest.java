package com.ynding.springboot;

import com.ynding.springboot.o.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStrap.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    @Test
    public void test() throws Exception {

        // 保存对象
        UserDto userDto = new UserDto("超人", 20);
        redisTemplate.opsForValue().set(userDto.getUsername(), userDto);

        userDto = new UserDto("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(userDto.getUsername(), userDto);

        userDto = new UserDto("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(userDto.getUsername(), userDto);

        Assert.assertEquals(new UserDto("超人", 20), redisTemplate.opsForValue().get("超人"));
//        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }
}
