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
    @RequestMapping("regist.action")
    public String regist(){
        return "/user/regist.jsp";
    }

}
