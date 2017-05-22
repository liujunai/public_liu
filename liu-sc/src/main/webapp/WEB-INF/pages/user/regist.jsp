<%--
  Created by IntelliJ IDEA.
  User: titanic
  Date: 17-5-20
  Time: 下午2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<html>
<head>
    <title>注册页面</title>

</head>
<body style="background-color: #cccccc">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/homepage.action" class="navbar-brand"><label>主页logo</label></a>
        </div>
        <div class="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/homepage.action"><span class="glyphicon glyphicon-home"></span>首页</a></li>
                <li class="active"><a href="/regist.action">注册页面</a></li>
                <li><a href=""></a></li>
                <li><a href=""></a></li>
                <li><a href=""></a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="registered" class="container" style="background-color: #ffffff;padding: 100px">
    <h3 class="page-header">新用户注册</h3>
    <form class="">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" id="username" placeholder="请输入您的用户名">
            <label></label>
        </div>
        <div class="form-group">
            <label for="loginpass">登录密码：</label>
            <input type="password" class="form-control" id="loginpass" placeholder="请输入您的密码">
            <label></label>
        </div>
        <div class="form-group">
            <label for="reloginpass">确认密码：</label>
            <input type="text" class="form-control" id="reloginpass" placeholder="请输入确认密码">
            <label></label>
        </div>
        <div class="form-group">
            <label for="email">邮&nbsp;&nbsp;箱：</label>
            <input type="text" class="form-control" id="email" placeholder="请输入您的Email">
            <label></label>
        </div>
        <div class="form-group">
            <label for="verifyCode">验证码：</label>
            <input type="text" class="form-control" id="verifyCode" placeholder="请输入验证码">
            <label></label>
        </div>
        <div class="form-group">
            <img src="" alt="">
            <label><a href="#">换一张</a></label>
        </div>

        <button type="button" class="btn btn-primary center-block">立即注册</button>
    </form>
</div>

</body>
</html>
