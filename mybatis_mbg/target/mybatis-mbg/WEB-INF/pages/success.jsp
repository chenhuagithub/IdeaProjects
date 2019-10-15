<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-18
  Time: 上午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>
    <table cellpadding="5" cellspacing="0" border="1">
        <th>id</th>
        <th>name</th>
        <th>course</th>
        <th>address</th>
        <th>birth</th>
        <c:forEach items="${teacher}" var="tea">
            <tr>
                <td>${tea.id}</td>
                <td>${tea.name}</td>
                <td>${tea.course}</td>
                <td>${tea.address}</td>
                <td>${tea.birth}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
