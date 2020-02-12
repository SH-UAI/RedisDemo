package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右压栈：后添加的对象排在后边
     */
    @Test
    public void setList(){
        redisTemplate.boundListOps("西游记").rightPush("唐三藏");
        redisTemplate.boundListOps("西游记").rightPush("孙悟空");
        redisTemplate.boundListOps("西游记").rightPush("猪悟能");
        redisTemplate.boundListOps("西游记").rightPush("沙悟净");

    }

    /*
    * 显示右压栈集合
    */
    @Test
    public void getList(){

        List list = redisTemplate.boundListOps("西游记").range(0, 10);
        System.out.println(list);

    }

    /*
    * 左压栈:后添加的排在前面
    *
    * */
    @Test
    public void setLeft(){
        redisTemplate.boundListOps("西游释厄传").leftPush("唐玄奘");
        redisTemplate.boundListOps("西游释厄传").leftPush("孙悟空");
        redisTemplate.boundListOps("西游释厄传").leftPush("猪八戒");
        redisTemplate.boundListOps("西游释厄传").leftPush("沙和尚");

    }

    /**
     * 显示左压栈集合
     */
    @Test
    public void getLeft(){

        List list = redisTemplate.boundListOps("西游释厄传").range(0, 10);
        System.out.println(list);
    }

    /**
     * 查询集合某个元素
     */
    @Test
    public void getListByIndex(){

        String index = (String) redisTemplate.boundListOps("西游释厄传").index(2);
        String value = (String) redisTemplate.boundListOps("西游记").index(2);
        System.out.println(index + "=======" + value);
    }

    /**
     * 移除集合某个元素
     */
    @Test
    public void removeByIndex(){
        redisTemplate.boundListOps("西游释厄传").remove(0,"沙和尚");
    }
}
