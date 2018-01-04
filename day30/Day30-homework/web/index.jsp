<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>主页</title>
  <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%--<h1>用户名：<span id="username"></span></h1>--%>
<%--<h1>密码：<span id="password"></span></h1>--%>

<%if (session.getAttribute("user")!=null){
    User user= (User) session.getAttribute("user");
    session.setAttribute("username",user.getUsername());
    out.write("终于成功了");
    System.out.println(user);
%>
<br>
<%
  }else{
    out.write("给我登进去呀！爸爸");

%>
<br>
<a href="http://localhost:8080/login.html">快点我呀！！！</a>
<%
  }
%>

</body>

<script type="text/javascript">
    $.getJSON("http://localhost:8080/day19/show",
        function (json,status) {
            if(status == "success"){
                $('#username').text(json['username']);
                $('#password').text(json['password']);
            }
        })
$.getJSON("http://localhost:8080/day19/show", function (data, status) {
    if(status=="success"){
        if (data == null) {
        } else {
            $('table')
                .append($('<tr>')
                    .append($('<th>').text("书名"))
                    .append($('<th>').text("作者"))
                    .append($('<th>').text("价格")));
            $.each(data, function (index, obj) {
                $('table')
                    .append($('<tr>')
                        .append($('<td>').append($('<a href="showBook.jsp">' + obj['bookname'] + '</a>')))
                        .append($('<td>').text(obj['zzname']))
                        .append($('<td>').text(obj['price'])));
            })
        }
    }
})

</script>
</html>
