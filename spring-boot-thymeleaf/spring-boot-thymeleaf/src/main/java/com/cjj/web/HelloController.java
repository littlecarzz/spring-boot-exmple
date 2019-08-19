package com.cjj.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/19 16:05
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(ModelMap modelmp) {
        modelmp.addAttribute("message", "https://www.cnblogs.com/xc-chejj/");
        return "hello";
    }
}
