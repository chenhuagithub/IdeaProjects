<%--
  Created by IntelliJ IDEA.
  User: 睁开双眼做场梦
  Date: 2019/8/13
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/LoginDemo/LoginServlet" method="post">
    用户名：<input type="text" placehoder="请输入用户名" name="loginName"><br>
    密码：<input type="password" placehoder="请输入密码" name="loginPwd"><br>
    <input type="submit" value="登陆">
</form>
</body>
</html>
