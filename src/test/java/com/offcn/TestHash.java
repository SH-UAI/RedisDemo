package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setHash(){
        redisTemplate.boundHashOps("水浒传").put("及时雨","宋江");
        redisTemplate.boundHashOps("水浒传").put("智多星","吴用");
        redisTemplate.boundHashOps("水浒传").put("豹子头","林冲");
        redisTemplate.boundHashOps("水浒传").put("霹雳火","秦明");
    }

    // 提取所有key
    @Test
    public void getHash(){

        Set keys = redisTemplate.boundHashOps("水浒传").keys();
        System.out.println(keys);
    }

    // 提取所有value
    @Test
    public void getHashValue(){

        List values = redisTemplate.boundHashOps("水浒传").values();
        System.out.println(values);
    }

    // 根据key提取值
    @Test
    public void getValueByKey(){

        Object o = redisTemplate.boundHashOps("水浒传").get("霹雳火");
        System.out.println(o);
    }

    //根据key移除值
    @Test
    public void deleteValueByKey(){

        redisTemplate.boundHashOps("水浒传").delete("及时雨");
    }
}
