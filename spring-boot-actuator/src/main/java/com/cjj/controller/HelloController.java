package com.cjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/27 16:10
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
        return "hello world";
    }
}
