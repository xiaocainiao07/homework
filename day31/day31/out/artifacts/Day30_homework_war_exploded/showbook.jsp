<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.2.1.min.js">

    </script>
</head>
<body>
<table></table>
</body>
<script type="text/javascript">
    $.getJSON("http://localhost:8080/show",
        function (data, status) {
            if(status=="success"){

                if(data!=null){
                    $('table')
                        .append($('<tr>')
                            .append($('<th>').text("书名"))
                            .append($('<th>').text("作者"))
                            .append($('<th>').text("价格")));
                    $.each(data,function (index,obj){
                        $('table')
                            .append($('<tr>')
                                .append($('<td>').text(obj['bookname']))
                                .append($('<td>').text(obj['zzname']))
                                .append($('<td>').text(obj['price'])));
                    })
                }
            }
        })
</script>
</html>