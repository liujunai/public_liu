<%--
  Created by IntelliJ IDEA.
  User: titanic
  Date: 17-5-26
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<html>
<head>

    <title>登录页面</title>

    <script type="text/javascript">
        $(function () { <%-- cookie  = Map<String(Cookie名称),Cookie(Cookie本身)>  --%>
           var loginname = ("${cookie.loginname.value}");
           if ("${form.loginname}"){
               loginname = "${form.loginname}"
           }
           $("#loginname").val(loginname)
        });
    </script>

</head>
<body style="background-color: #cccccc">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/homepage.action" class="navbar-brand"><label>主页logo</label></a>
        </div>
        <div class="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty sessionScope.sessionUser}">
                        <li><a href="/homepage.action"><span class="glyphicon glyphicon-home"></span>首页</a></li>
                        <li class="active"><a href="/login.action">登录</a></li>
                        <li><a href="/regist.action">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>我的购物车</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>我的订单</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-sort"></span>修改密码</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-remove-sign"></span>退&nbsp;&nbsp;出</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-send"></span>联系我们</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

    </div>
</nav>


<div class="container">
    <div>
        <img class="img-responsive" src="${path}/images/itcast_link.gif">
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <img class="img-responsive" src="${path}/images/zj.png">
        </div>
        <div class="col-md-6">
            <h3 class="page-header">会员登录</h3>
            <a href="/regist.action" class="btn btn-primary">立即注册</a>
            <form action="/user/logins.action" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="loginname" class="col-md-4">用户名</label>
                    <input type="text" id="loginname" name="loginname" value="${form.loginname}" class="col-md-8">
                    <label class="col-md-4">${errors.loginname}</label>
                </div>
                <div class="form-group">
                    <label for="loginpass" class="col-md-4">密&nbsp;&nbsp;&nbsp;码</label>
                    <input type="password" id="loginpass" name="loginpass" class="col-md-8">
                    <label class="col-md-4">${errors.loginpass}</label>
                </div>
                <div class="form-group">
                    <label for="verifyCode" class="col-md-3">验证码</label>
                    <input type="text" id="verifyCode" name="verifyCode" value="${form.verifyCode}" class="col-md-3">
                    <img class="col-md-3" src="/verfiyCode.action">
                    <label class="col-md-3"><a href="#">换一张</a></label>
                    <label class="col-md-4">${errors.verifyCode}</label>
                </div>

                <input type="submit" class="btn btn-warning" value="登&nbsp;&nbsp;&nbsp;录">
            </form>
        </div>
    </div>
</div>


</body>
</html>
