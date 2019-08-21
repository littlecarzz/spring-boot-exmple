package com.cjj;

import com.cjj.model.User;
import com.cjj.rabbit.object.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/21 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {
    @Autowired
    private UserSender userSender;

    @Test
    public void test() {
        User user=new User();
        user.setName("cjj");
        user.setPass("1");
        userSender.send(user);
    }
}
