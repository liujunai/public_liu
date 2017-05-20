package com.liu.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by titanic on 17-5-20.
 */
@Controller
public class HomeController {

    @RequestMapping("/home.action")
    public String login(){
        return "/homepage.jsp";
    }

}
