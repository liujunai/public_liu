package com.liu.sc.controller.user;

import com.liu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by titanic on 17-5-24.
 */
@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/ajaxLoginname.action",method = RequestMethod.POST)
    public void ajaxLoginname(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String loginname = req.getParameter("loginname");
        boolean b = userService.ajaxLoginname(loginname);
        resp.getWriter().print(b);
    }

    @RequestMapping(value = "/user/ajaxEmail.action",method = RequestMethod.POST)
    public void ajaxEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String email = req.getParameter("loginname");
        boolean b = userService.ajaxLoginname(email);
        resp.getWriter().print(b);
    }

    @RequestMapping(value = "/user/ajaxVerifyCode.action",method = RequestMethod.POST)
    public void ajaxVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
       String verifyCode = req.getParameter("verifyCode");
       String vcode = (String) req.getSession().getAttribute("vCode");
       //忽略大小写进行比较
       boolean b = verifyCode.equalsIgnoreCase(vcode);
       resp.getWriter().print(b);
    }



    @RequestMapping("/user/registered.action")
    public String registered(){
        System.out.println("aaggggggggggaa");
        return "";
    }
}
