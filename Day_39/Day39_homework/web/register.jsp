<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/15
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    <input type="hidden" name="method" value="regist"/>
    用户名：<input type="text" name="username" value=""/><br/>
    密　码：<input type="password" name="password"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
