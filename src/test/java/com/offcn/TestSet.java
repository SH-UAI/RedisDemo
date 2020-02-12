package com.offcn;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestSet {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.boundSetOps("三国").add("曹操");
        redisTemplate.boundSetOps("三国").add("孙权");
        redisTemplate.boundSetOps("三国").add("刘备");

    }

    @Test
    public void getValue(){

        Set members = redisTemplate.boundSetOps("三国").members();
        System.out.println(members);
    }

    @Test
    public void deleteValue(){

        redisTemplate.boundSetOps("三国").remove("孙权");
    }

    @Test
    public void  deleteAll(){

        redisTemplate.delete("三国");
    }
}
