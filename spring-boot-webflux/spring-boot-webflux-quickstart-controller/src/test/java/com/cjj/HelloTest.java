package com.cjj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 16:03
 */
@RunWith(SpringRunner.class)
@WebFluxTest
public class HelloTest {
    @Autowired
    private WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }
}
