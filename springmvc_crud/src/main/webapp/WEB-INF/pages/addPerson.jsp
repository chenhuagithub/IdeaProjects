<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-20
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div style="margin-left: 40%;margin-top: 100px;">
        <form action="addPerson" method="post">
            <p>名字<input type="text" name="name"><form:errors path="name"></form:errors></p>
            <p>邮箱<input type="text" name="email"><form:errors path="email"></form:errors> </p>
            <p>性别<input type="text" name="gender"><form:errors path="gender"></form:errors> </p>
            <p>生日<input type="text" name="birth"><form:errors path="birth"></form:errors> </p>
            <p>薪资<input type="text" name="salary"><form:errors path="salary"></form:errors></p>
            <p><input type="submit" value="提交"></p>
        </form>
    </div>

</body>
</html>
