<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-19
  Time: 下午4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工信息</title>
</head>
<body>
    <div style="margin-left: 40%;margin-top: 100px">
        <span style="color: blue;size: 10px;">员工信息添加</span><br>
        <span><a href="findAllEmployee">首页</a></span>
        <form action="employee" method="post">
            <p>名字<input type="text" name="lastName"></p>
            <p>邮箱<input type="text" name="email"></p>
            <p>性别<input type="text" name="gender"></p>
            <p>部门<select name="department.departmentName">
                <option value="java开发部门">java开发部门</option>
                <option value="python开发部">python开发部</option>
                <option value="c++开发部">c++开发部</option>
                <option value="Go语言开发部">Go语言开发部</option>
                <option value="PHP开发部">PHP开发部</option>
                <option value="C#开发部门">C#开发部门</option>
            </select></p>
            <p><input type="submit" value="提交"></p>
        </form>
    </div>


</body>
</html>
