<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-20
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div style="margin-left: 40%;margin-top: 100px;">
        <a href="gotoAddPerson">新增</a>
        <table cellpadding="5px" cellspacing="0" border="1px">
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th>gender</th>
            <th>birth</th>
            <th>salary</th>
            <c:forEach items="${allPerson}" var="person">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.email}</td>
                    <td>${person.gender}</td>
                    <td>${person.birth}</td>
                    <td>${person.salary}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
