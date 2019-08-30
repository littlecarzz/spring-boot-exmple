package com.cjj.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 9:16
 */
@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("The OrderRunner1 start to initialize ...");
    }
}
