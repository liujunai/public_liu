package com.liu.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by titanic on 17-5-20.
 */
@Controller
public class HomeController {

    //主页
    @RequestMapping("/homepage.action")
    public String homepage(){
        return "/homepage.jsp";
    }

    //注册页面
    @RequestMapping("/regist.action")
    public String regist(){
        return "/user/regist.jsp";
    }

    //登录页面
    @RequestMapping("/login.action")
    public String login(){
        return "/user/login.jsp";
    }

    //修改密码
    @RequestMapping("/user/pwd.action")
    public String pwd(){
        return "/user/pwd.jsp";
    }

}
