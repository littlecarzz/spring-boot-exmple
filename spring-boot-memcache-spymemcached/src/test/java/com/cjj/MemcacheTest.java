package com.cjj;

import com.cjj.config.MemcacheRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 10:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcacheTest {
    @Resource
    private MemcacheRunner memcacheRunner;

    @Test
    public void testSetGet()  {
        MemcachedClient memcachedClient = memcacheRunner.getMemcachedClient();
        memcachedClient.set("testkey",1000,"666666");
        System.out.println("***********  "+memcachedClient.get("testkey").toString());
    }
}
