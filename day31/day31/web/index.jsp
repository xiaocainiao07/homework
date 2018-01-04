<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="index"
          uri="http://lanou3g.com" %>
<%@taglib prefix="lanou3g" uri="http://lanou3g.com" %>
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

%>
<table style="border: 1px solid black;text-align: center">

</table>
<%
  }else{
    out.write("给我登进去呀！爸爸");

%>
<br>

<%
  }
%>
<a href="http://localhost:8080/login.jsp">退出</a>
<input type = "button" name="exit" value="退出">

</body>

<script type="text/javascript">
//    $.getJSON("http://localhost:8080/day19/show",
//        function (json,status) {
//            if(status == "success"){
//                $('#username').text(json['username']);
//                $('#password').text(json['password']);
//            }
//        })
$.getJSON("http://localhost:8080/show", function (data, status) {
    if(status=="success"){
        console.log(data);
        $('table')
                .append($('<tr>')
                    .append($('<th>').text("书名"))
                    .append($('<th>').text("作者"))
                    .append($('<th>').text("价格")));
        }
            $.each(data, function (index, obj) {
                $('table')
                    .append($('<tr>')
                        .append($('<td>').text(obj['bookname'] ))
                        .append($('<td>').text(obj['zzname']))
                        .append($('<td>').text(obj['price'])));
            })

})

</script>
</html>
