<%--
  Created by IntelliJ IDEA.
  User: titanic
  Date: 17-5-20
  Time: 下午2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--项目虚拟路径--%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%--bootstrap加载响应式--%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">

<link rel="stylesheet" href="${path}/css/style.css">



<%-- bootstrap的资源文件 --%>
<link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>