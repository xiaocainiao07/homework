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

  <div class="icon"></div>
    <%--<a href="<c:url value='/jsps/book/book1.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book1.jsp'/>">Java就业培训教程</a>--%>
  <%--</div>--%>
  <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book2.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book2.jsp'/>">Java对象持久化技术详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book3.jsp'/>"><img src="<c:url value='/book_img/9265169-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book3.jsp'/>">Java</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book4.jsp'/>"><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book4.jsp'/>">Java编程思想</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book5.jsp'/>"><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book5.jsp'/>">企业应用</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book6.jsp'/>"><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book6.jsp'/>">Java核心技术</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book7.jsp'/>"><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book7.jsp'/>">深入详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/book8.jsp'/>"><img src="<c:url value='/book_img/22722790-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/book8.jsp'/>">JavaScript</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/22788412-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java Web</a>--%>
  <%--</div>--%>

  
  </body>
  <script src="../../js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">

      var url = "http://localhost:8080/bookstore/book?method=";

      var search = location.search;
      var number = search.indexOf("=");

      var cid = search.substring(number+1);
      switch (cid){
          case "1":url = url+"category&category="+cid; break;
          case "2":url = url+"category&category="+cid;break;
          case "3":url = url+"category&category="+cid;break;
          default:url = url+"findAll";

      }
      $.getJSON(url,
          function (data,status) {
              if(status=="success"){
                  if (data!=null){
                      $.each(data,function (index,objcet) {

                          var image = objcet['image'];
                          $('#icon')
                              .append($('<div>').attr("class","icon")
                                  .append($('<a>').attr("href","../../book?method=load&bid="+objcet['bid']).html($('<img>').attr("src","/bookstore/"+image)))
                                  .append($('<br>'))
                                  .append($('<a>')
                                      .attr("href","../../user/book?method=load&bid="+objcet['bid'])
                                      .text(objcet['bname']))
                              )
                      })
                  }
              }

          })






  </script>
</html>

