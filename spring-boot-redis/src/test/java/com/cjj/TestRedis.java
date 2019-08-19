package com.cjj;

import com.cjj.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/19 10:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test02() throws Exception {
        User user = new User(1l,"aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("user", user);
        Assert.assertEquals(true, redisTemplate.hasKey("user"));
        System.out.println("user is exists");
    }
    @Test
    public void test03() throws Exception {
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        User user = operations.get("user");
        System.out.println(user);
    }

    @Test
    public void testObj() throws Exception {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.cjj", user);
        operations.set("com.neo.f", user,1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        Assert.assertEquals(true, redisTemplate.hasKey("com.neo.f"));
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
