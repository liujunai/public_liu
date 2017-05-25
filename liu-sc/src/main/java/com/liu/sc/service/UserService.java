package com.liu.sc.service;

import com.liu.sc.model.User;

/**
 * Created by titanic on 17-5-24.
 */
public interface UserService
{
    //ajax校验用户是否注册
    public boolean ajaxLoginname(String loginname);
    //ajax校验邮箱是否注册
    public boolean ajaxEmail(String email);

    public void insert(User user);

}
