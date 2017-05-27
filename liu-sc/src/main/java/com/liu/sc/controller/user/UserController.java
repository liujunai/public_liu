package com.liu.sc.controller.user;

import com.liu.sc.exception.UserException;
import com.liu.sc.model.User;
import com.liu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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

    //修改密码
    @RequestMapping("/user/pwds.action")
    public String pwds(User fuser,HttpServletRequest req)
    {
        //从session中获取uid
        User user = (User) req.getSession().getAttribute("sessionUser");
        if (user == null){
            req.setAttribute("msg","您还没有登录");
            return "/user/login.jsp";
        }
        Map<String,String> userBean = new HashMap<String, String>();
        userBean.put("uid",user.getUid());
        userBean.put("newloginpass",fuser.getNewloginpass());
        userBean.put("loginpass",fuser.getLoginpass());
        try
        {
            userService.updatePass(userBean);
            req.setAttribute("msg","修改密码成功");
            req.setAttribute("code","success");
            return "/msg.jsp";
        } catch (UserException e)
        {
            req.setAttribute("msg",e.getMessage());//保存错误信息到request
            req.setAttribute("form",fuser);
            return "/user/pwd.jsp";
        }
    }


    //登录页面验证
    @RequestMapping("/user/logins.action")
    public String logins(User fuser,HttpServletRequest req,HttpServletResponse resp){
        Map<String,String> errors = validateLogin(fuser,req.getSession());
        if (errors.size() >0){
            req.setAttribute("errors",errors);
            req.setAttribute("form",fuser);
            return "/user/login.jsp";
        }
        User user = userService.getlogin(fuser);
        //判断用户是否存在
        if (user == null){
            req.setAttribute("login","用户名或密码错误!");
            req.setAttribute("form",fuser);
            return "/user/login.jsp";
        }else {
            //判断用户是否激活
            if (!user.getStatus()){
                req.setAttribute("login","您还没有激活账号");
                req.setAttribute("form",fuser);
                return "/user/login.jsp";
            }else {
                //保存用户到session中
                req.getSession().setAttribute("sessionUser",user);
                String loginname = user.getLoginname();
                try
                {
                    loginname = URLEncoder.encode(loginname,"utf-8");
                    Cookie cookie = new Cookie("loginname",loginname);
                    cookie.setMaxAge(60 * 60 * 24 * 10);
                    resp.addCookie(cookie);
                } catch (UnsupportedEncodingException e)
                {
                    throw new RuntimeException(e);
                }
                return "redirect:/homepage.action";
            }
        }



    }


    //对登录表单校验
    private Map<String,String> validateLogin(User user,HttpSession session){
        Map<String,String> errors = new HashMap<String, String>();

        String loginname = user.getLoginname();
        if (loginname == null || loginname.trim().isEmpty()){
            errors.put("loginname","用户名不能为空!");
        }

        String loginpass = user.getLoginpass();
        if (loginpass == null || loginpass.trim().isEmpty()){
            errors.put("loginpass","密码不能为空");
        }

        String verifyCode = user.getVerifyCode();
        String vCode = (String) session.getAttribute("vCode");
        if (verifyCode == null || verifyCode.trim().isEmpty()){
            errors.put("verifyCode","验证码不能为空!");
        }else if (!verifyCode.equalsIgnoreCase(vCode)){
            errors.put("verifyCode","验证码错误!");
        }

        return errors;
    }




    //注册用户验证
    @RequestMapping("/user/registered.action")
    public String registered(User user,HttpServletRequest req){

        //进行校验
        Map<String,String> errors = validateRegist(user,req.getSession());
        if (errors.size() > 0){
            req.setAttribute("errors",errors);
            req.setAttribute("form",user);
            return "/user/regist.jsp";
        }
        userService.insert(user);
        req.setAttribute("code","success");
        req.setAttribute("msg","注册成功,请马上到邮箱激活");
        return "/msg.jsp";
    }

    //对注册表单校验
    //对表单的字段进行逐个校验,如果有错误信息,使用当前字段名称为key,错误信息为value,保存到map中
    //最后返回map
    private Map<String,String> validateRegist(User user, HttpSession session){
        Map<String,String> errors = new HashMap<String, String>();

        //登录名校验
        String loginname = user.getLoginname();
        if (loginname == null || loginname.trim().isEmpty()){
            errors.put("loginname","用户名不能为空！");
        } else if (loginname.length() < 4 || loginname.length() > 13){
            errors.put("loginname","用户名长度必须在4~12之间！");
        }else if (!userService.ajaxLoginname(loginname)){
            errors.put("loginname","用户名已被注册!");
        }

        //登录密码校验
        String loginpass = user.getLoginpass();
        if (loginpass == null || loginpass.trim().isEmpty()){
            errors.put("loginpass","密码不能为空！");
        } else if (loginpass.length() < 3 || loginpass.length() > 13){
            errors.put("loginpass","密码长度必须在4~12之间！");
        }

        //确认密码校验
        String reloginpass = user.getReloginpass();
        if (reloginpass == null || reloginpass.trim().isEmpty()){
            errors.put("reloginpass","确认密码不能为空！");
        } else if (!reloginpass.equals(loginpass)){
            errors.put("reloginpass","两次输入的密码不一致");
        }

        //email校验
        String email = user.getEmail();
        if (email == null || email.trim().isEmpty()){
            errors.put("email","Email不能为空！");
        } else if (!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
            errors.put("email","Email格式错误！");
        }else if (!userService.ajaxEmail(email)){
            errors.put("email","Email已被注册!");
        }

        //验证码校验
        String verifyCode = user.getVerifyCode();
        String vCode = (String) session.getAttribute("vCode");
        if (verifyCode == null || verifyCode.trim().isEmpty()){
            errors.put("verifyCode","验证码不能为空！");
        } else if (!verifyCode.equalsIgnoreCase(vCode)){
            errors.put("verifyCode","验证码错误！");
        }

        return errors;
    }


}
