<%--
  Created by IntelliJ IDEA.
  User: titanic
  Date: 17-5-25
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp"%>
<html>
<head>
    <title>成功页面</title>
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
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.sessionUser.loginname}</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>我的购物车</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>我的订单</a></li>
                        <li><a href="/user/pwd.action"><span class="glyphicon glyphicon-sort"></span>修改密码</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-remove-sign"></span>退&nbsp;&nbsp;出</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-send"></span>联系我们</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <c:choose>
        <c:when test="${code eq 'success' }">
            <c:set var="img" value="${path}/images/duihao.jpg"/>
            <c:set var="title" value="成功"/>
        </c:when>
        <c:when test="${code eq 'error' }">
            <c:set var="img" value="${path}/images/cuohao.jpg"/>
            <c:set var="title" value="失败"/>
        </c:when>
    </c:choose>

    <h3>${msg}</h3>

    <a href="/user/logins.action" class="btn btn-block">登录</a>
    <a href="/homepage.action" class="btn btn-block">主页</a>
</div>


</body>
</html>
