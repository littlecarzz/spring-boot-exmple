package com.cjj.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.krb5.internal.KrbApErrException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/23 14:39
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    /**
     * 登录过程其实只是处理异常的相关信息，具体的登录验证交给 Shiro 来处理
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map) {
        System.out.println("HomeController.login()");
        //登陆失败从request中获取shiro处理异常的信息
        // shiroLoginFailure:就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        //错误信息
        String msg = "";
        if (null != exception) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            }else{
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}
