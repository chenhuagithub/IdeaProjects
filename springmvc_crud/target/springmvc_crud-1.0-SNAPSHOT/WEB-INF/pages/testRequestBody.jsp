<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-20
  Time: 下午5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<body>


<div style="margin-left: 40%;margin-top: 100px;">
    <form action="testHttpEntity" method="post">
        <p>名字<input type="text" name="name"></p>
        <p>邮箱<input type="text" name="email"></p>
        <p>性别<input type="text" name="gender"></p>
        <p>生日<input type="text" name="birth"></p>
        <p>薪资<input type="text" name="salary"></p>
        <p><input type="submit" value="提交"></p>
    </form>
</div>
<a href="testRequestBody">发送json数据</a>
<script type="text/javascript">
    var emp = {name: 'chenhua', email:"1608299725@qq.com", gender: "男", birth: "2017-2-3", salary: 346.34};
    var empStr = JSON.stringify(emp);
    $("a:first").click(function () {
        $.ajax({
            url: 'testRequestBody',
            type: 'post',
            data: empStr,
            contentType: "application/json",
            success: function () {
                alert("数据传输成功");
            }
        });
        return false;
    });
</script>

</body>
</html>
