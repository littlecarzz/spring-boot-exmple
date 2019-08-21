package com.cjj;

import com.cjj.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 16:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicSender topicSender;

    @Test
    public void test() {
        topicSender.send();
    }
    @Test
    public void test1() {
        topicSender.send1();
    }
    @Test
    public void test2() {
        topicSender.send2();
    }
}
