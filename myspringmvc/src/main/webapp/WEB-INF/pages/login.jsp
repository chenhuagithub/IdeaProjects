<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-17
  Time: 上午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

    <h3><fmt:message key="welcomeinfo"></fmt:message></h3>
    <form action="user/login" method="post">
        <p><fmt:message key="username"></fmt:message>:<input type="text" name="username"></p>
        <p><fmt:message key="password"></fmt:message> <input type="text" name="password"></p>
        <p><input type="submit" value="<fmt:message key="loginBtn"></fmt:message>"></p>
    </form>
</body>
</html>
