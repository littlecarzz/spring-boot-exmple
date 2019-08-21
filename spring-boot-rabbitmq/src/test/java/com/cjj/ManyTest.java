package com.cjj;

import com.cjj.rabbit.many.TestSender1;
import com.cjj.rabbit.many.TestSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
    @Autowired
    private TestSender1 testSender1;
    @Autowired
    private TestSender2 testSender2;

    @Test
    public void oneToMany() throws Exception{
        for (int i = 0; i < 10; i++) {
            testSender1.send(i);
        }
    }
    @Test
    public void manyToMany() throws Exception{
        for (int i = 0; i < 10; i++) {
            testSender1.send(i);
            testSender2.send(i);
        }
    }
}
