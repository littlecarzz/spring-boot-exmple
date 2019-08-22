package com.cjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 16:06
 */
@SpringBootApplication
public class MultiMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiMongoApplication.class, args);
    }
}
