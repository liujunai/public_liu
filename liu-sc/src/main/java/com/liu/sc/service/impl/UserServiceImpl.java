package com.liu.sc.service.impl;

import com.liu.sc.dao.UserDao;
import com.liu.sc.model.User;
import com.liu.sc.service.UserService;
import com.liu.sc.utils.Email;
import com.liu.sc.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.UUID;

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

    public void insert(User user)
    {
        user.setUid(UUID.randomUUID().toString());
        user.setStatus(false);
        user.setActivationcode(UUID.randomUUID().toString() + UUID.randomUUID().toString());

        userDao.insert(user);


        //把配置文件内容加载到prop中
        Properties prop = new Properties();
        try
        {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        //登录邮件服务器,得到session
        String host = prop.getProperty("host");
        String name = prop.getProperty("name");
        String pass = prop.getProperty("pass");
        Session session = EmailUtils.createSession(host,name, pass);

        String from = prop.getProperty("from");
        String to = user.getEmail();
        String subject = prop.getProperty("subject");
        // MessageFormat.format方法会把第一个参数中的{0}，使用第二个参数来替换
        String content = MessageFormat.format(prop.getProperty("content"), user.getActivationcode());

        Email email = new Email(from,to,subject,content);

        try
        {
            //发送邮件
            EmailUtils.send(session,email);
        } catch (MessagingException e)
        {
           throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
