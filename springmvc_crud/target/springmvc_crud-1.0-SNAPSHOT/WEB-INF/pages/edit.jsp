<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-20
  Time: 上午8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="updateEmployee" method="post">
        <p><input type="text" name="id" value="${emp.id}" hidden="hidden"></p>
        <p>名字<input type="text" name="lastName" value="${emp.lastName}"></p>
        <p>邮箱<input type="text" name="email" value="${emp.email}"></p>
        <p>性别<input type="text" name="gender" value="${emp.gender}"></p>
        <p>部门<input type="text" name="department.departmentName" value="${emp.department.departmentName}"></p>
        <p><input type="submit" value="修改"></p>
    </form>

</body>
</html>
