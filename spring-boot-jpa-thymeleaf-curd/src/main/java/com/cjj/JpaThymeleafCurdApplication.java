package com.cjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/26 15:15
 */
@SpringBootApplication
public class JpaThymeleafCurdApplication  extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JpaThymeleafCurdApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(JpaThymeleafCurdApplication.class, args);
    }
}
