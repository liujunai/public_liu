package com.liu.sc.dao;

import com.liu.sc.model.User;

import java.util.Map;

/**
 * Created by titanic on 17-5-24.
 */
public interface UserDao extends BaseDao<User> {

    //ajax校验用户是否注册
    public boolean ajaxLoginname(String loginname);
    //ajax校验邮箱是否注册
    public boolean ajaxEmail(String email);
    //登录
    public User getlogin(User fuser);
    //查询原密码是否正确
    public boolean findUser(Map userBean);
    //修改密码
    public void updatePass(Map userBean);

}
