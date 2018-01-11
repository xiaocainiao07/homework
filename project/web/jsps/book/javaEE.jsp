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
    <a href="<c:url value='/jsps/book/book5.jsp'/>"><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book5.jsp'/>">企业应用</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book6.jsp'/>"><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book6.jsp'/>">Java核心技术</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book7.jsp'/>"><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book7.jsp'/>">深入详解</a>
</div>
<div class="icon">
    <a href="<c:url value='/jsps/book/book8.jsp'/>"><img src="<c:url value='/book_img/22722790-1_l.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/jsps/book/book8.jsp'/>">Javascript</a>
</div>



</body>

</html>

