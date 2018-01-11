<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            font-size: 10pt;
        }
        .icon {
            margin:10px;
            border: solid 2px gray;
            width: 160px;
            height: 180px;
            text-align: center;
            float: left;
        }
    </style>
</head>

<body>

<div class="icon">
    <a href="<c:url value='/jsps/book/book1.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book1.jsp'/>">Java就业培训教程</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book2.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book2.jsp'/>">Java对象持久化技术详解</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book3.jsp'/>"><img src="<c:url value='/book_img/9265169-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book3.jsp'/>">Java</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book4.jsp'/>"><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book4.jsp'/>">Java编程思想</a>
</div>



</body>

</html>

