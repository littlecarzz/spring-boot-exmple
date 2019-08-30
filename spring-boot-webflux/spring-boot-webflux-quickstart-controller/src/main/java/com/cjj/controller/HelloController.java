package com.cjj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 15:59
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello, world!");
    }

    @GetMapping("/hello1")
    public Flux<String> hello1() {
        return Flux.just("hello1");
    }
}
