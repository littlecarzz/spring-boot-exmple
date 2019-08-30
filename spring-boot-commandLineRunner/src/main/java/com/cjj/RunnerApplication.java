package com.cjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 9:13
 */
@SpringBootApplication
public class RunnerApplication {
    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(RunnerApplication.class, args);
        System.out.println("The service has started.");
    }
}
