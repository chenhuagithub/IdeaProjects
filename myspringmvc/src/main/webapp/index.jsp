<%--
  Created by IntelliJ IDEA.
  User: chenhua
  Date: 19-7-16
  Time: 上午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <a href="haha/hello">hello world</a>
    <hr>
    <a href="haha/antTest03">?通配符</a>
    <hr>
    <form action="mybook/book" method="post">
        <p>书名<input type="text" name="bookName"></p>
        <p>作者<input type="text" name="author"></p>
        <p>价格<input type="text" name="price"></p>
        <p>库存<input type="text" name="stock"></p>
        <p>销售<input type="text" name="sales"></p>
        <p>首都<input type="text" name="address.province"></p>
        <p>城市<input type="text" name="address.city"></p>
        <p>街道<input type="text" name="address.street"></p>
        <p><input type="submit" value="添加"></p>
        <hr>
    </form>
    <form action="mybook/book/2" method="post">
        <input name="_method" value="delete">
        <input type="submit" value="删除图书">
    </form>
<%--    <a href="mybook/book/2">删除图书</a><br>--%>
<%--    <a href="mybook/book/2">修改图书</a><br>--%>
    <form action="mybook/book/2" method="post">
        <input name="_method" value="put">
        <input type="submit" value="更新图书">
    </form>
    <a href="mybook/book/2">查询图书</a><br>
    <hr>
    <a href="model/view">hander01</a>
    <a href="model/view2">hander02</a>
    <a href="model/view3">hander03</a>
    <a href="model/view4">hander04</a>
    <a href="model/view5">hander05</a>
    <a href="model/view6">hander06</a>
    <a href="user/login">去登录界面</a>
</body>
</html>
