package com.liu.sc.service.impl;

import com.liu.sc.dao.UserDao;
import com.liu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by titanic on 17-5-24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean ajaxLoginname(String loginname)
    {
        return userDao.ajaxLoginname(loginname);
    }

    public boolean ajaxEmail(String email)
    {
        return userDao.ajaxEmail(email);
    }
}
