package com.liu.sc.dao.impl;

import com.liu.sc.dao.UserDao;
import com.liu.sc.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by titanic on 17-5-24.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public UserDaoImpl(){
        super.setNs("com.liu.sc.mapper.UserMapper");
    }


    public boolean ajaxLoginname(String loginname) {
        Integer num =  super.getSqlSession().selectOne(super.getNs() + ".ajaxLoginname",loginname);
        return num.intValue() == 0;
    }

    public boolean ajaxEmail(String email) {
        Integer num =  super.getSqlSession().selectOne(super.getNs() + ".ajaxEmail",email);
        return num.intValue() == 0;
    }

    public User getlogin(User fuser)
    {
        return super.getSqlSession().selectOne(super.getNs() + ".findByLoginnameAndLoginpass",fuser);
    }

    public boolean findUser(Map userBean)
    {
        Integer num =  super.getSqlSession().selectOne(super.getNs() + ".findByUidAndPass",userBean);
        return num.intValue() > 0;
    }

    public void updatePass(Map userBean)
    {
        super.getSqlSession().update(super.getNs() + ".updatePass",userBean);
    }


}
