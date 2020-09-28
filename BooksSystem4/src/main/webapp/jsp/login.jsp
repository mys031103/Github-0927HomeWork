<%--
  Created by IntelliJ IDEA.
  User: 20254
  Date: 2020/9/27
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <h2>图书借阅系统</h2>
    <form action="/login" method="post">
        <p>登陆账号:<input type="text" name="userCode"></p>
        <p>登录密码:<input type="password" name="password"></p>
        <p>
            <input type="submit" value="登录" style="margin-left: 25px;">
            <input type="button" value="注册用户">
        </p>
    </form>
    <c:if test="${flag==false}">
        登录失败，登录账号或密码错误，请重新输入
    </c:if>
</center>
</body>
</html>
