<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-17
  Time: 下午4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>

    <div style="margin-left: 40%">
        <a href="addInfo">新增</a>
        <table cellpadding="5px" cellspacing="0" border="1px">
            <th>id</th>
            <th>名字</th>
            <th>邮箱</th>
            <th>性别</th>
            <th>部门</th>
            <c:forEach items="${info.getList()}" var="em">
                <tr>
                    <td>${em.id}</td>
                    <td>${em.lastName}</td>
                    <td>${em.email}</td>
                    <td>${em.gender}</td>
                    <td>${em.department.departmentName}</td>
                    <td><a href="gotoedit?id=${em.id}">编辑</a></td>
                    <td><a href="deleteEmployee?id=${em.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="employee?page=1">首页</a>&nbsp;<a href="employee?page=${info.getPageNum()-1}">上一页</a>&nbsp;&nbsp;${info.getPageNum()}<a href="employee?page=${info.getPageNum()+1}">下一页</a>&nbsp;&nbsp;<a href="employee?page=${info.getPages()}">末页</a>
    </div>

</body>
</html>
