package com.cjj;

import com.cjj.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 16:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void test() {
        fanoutSender.send();
    }
}
