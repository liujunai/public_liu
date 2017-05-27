<%--
  Created by IntelliJ IDEA.
  User: titanic
  Date: 17-5-27
  Time: 下午2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/homepage.action" class="navbar-brand"><label>主页logo</label></a>
        </div>
        <div class="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty sessionScope.sessionUser}">
                        <li class="active"><a href="/homepage.action"><span class="glyphicon glyphicon-home"></span>首页</a></li>
                        <li><a href="/login.action">登录</a></li>
                        <li><a href="/regist.action">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.sessionUser.loginname}</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>我的购物车</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>我的订单</a></li>
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-sort"></span>修改密码</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-remove-sign"></span>退&nbsp;&nbsp;出</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-send"></span>联系我们</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h3 class="page-header">修改密码</h3>
    <form action="/user/pwds.action" method="post">
        <div class="form-group">
            <label for="loginpass">原密码：</label>
            <input type="password" id="loginpass" name="loginpass">
            <label></label>
        </div>
        <div class="form-group">
            <label for="newloginpass">新密码：</label>
            <input type="password" id="newloginpass" name="newloginpass">
            <label></label>
        </div>
        <div class="form-group">
            <label for="reloginpass">确认密码：</label>
            <input type="password" id="reloginpass" name="reloginpass">
            <label></label>
        </div>
        <div class="form-group">
            <img src="/verfiyCode.action">
            <a href="#">换一张</a>
        </div>
        <div class="form-group">
            <label for="verifyCode">验证码：</label>
            <input type="text" id="verifyCode" name="verifyCode">
            <label></label>
        </div>

        <input type="submit" class="btn btn-primary" value="确认修改">

    </form>

</div>

</body>
</html>
