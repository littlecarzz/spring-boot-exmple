package com.cjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/20 16:38
 */
@SpringBootApplication
@MapperScan("com.cjj.mapper")
public class MybatisAnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisAnnotationApplication.class, args);
    }
}
