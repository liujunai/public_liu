package com.liu.sc.controller;

import com.liu.sc.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by titanic on 17-5-23.
 */


@Controller
public class VerfiyCodeController {

    @Autowired
    VerifyCode verifyCode;

    @RequestMapping("verfiyCode.action")
    public void verfiyCode (HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //获取一次性验证码图片
        BufferedImage image = verifyCode.getImage();

        //获取图片上的文本
        //System.out.println(verifyCode.getText());

        //把图片写到指定流中
        verifyCode.output(image,resp.getOutputStream());

        //把文本保存到session中,为验证做准备
        req.getSession().setAttribute("vCode",verifyCode.getText());
    }
}
