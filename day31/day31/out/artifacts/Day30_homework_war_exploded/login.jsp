<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/4
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style type="text/css">
        .div{
            position:fixed;
            width: 1888px;
            height: 950px;
        }
        .div1{
            width: 1900px;
            height: 60px;
        }
        .navigation{
            width: 300px;
            height: 50px;
            float: left;
        }
        .navigation-1{
            width: 300px;
            height: 40px;
            float: right;
        }

        .text{
            position: absolute;
            height: 900px;
            width: 1900px;
            background-color: #d2e0eb;
        }

        .text-1{
            position:relative;
            left: 20%;
            top:25%;

        }
        .text-2{
            width: 400px;
            height: 500px;
            background-color: #ffffff;
            position: absolute;
            left: 70%;
            top:20%;

        }
        .loing-button{
            color: white;
            font-size: 30px;
            background-color: #1a7bff;
            border: none;
            width: 300px;
            height: 40px;
        }


    </style>
</head>
<body >
<form action="login" method="post">
<div class="div">
    <div class="div1">
        <div class="navigation ">
            <span style="float: right ;font-size: 22px ;padding-left: 10px ; padding-top: 5px">登陆</span>

            <img src="tp/QQ截图20171223195133.png" style="float: right">
        </div>
        <div class="navigation-1">
            <span id="demo"></span>
            <span style="color: dodgerblue ;font-size: 20px">网易云首页</span>
            <span style="color: dodgerblue; font-size: 20px">帮助与文档</span>
        </div>
    </div>
    <div class="text">
        <img src="tp/QQ截图20171223195121.png"  class="text-1" >
    </div>

    <div class="text-2">

        <p style="text-align: center ; font-size: 40px">网易登陆</p>
        <div style="text-align: center">

            <input id="a" type="text"  placeholder="用户名"  value=${cookie.user.value}  id="username"
                   name="username" style="width: 300px;height: 30px" onclick="a(this)">
        </div>
        <div style="text-align: center ; padding-top: 50px">

            <input id="b" type="text"  placeholder="登陆密码"   name="password"
                   id="password" style="width: 300px;height: 30px " onclick="b(this)">
        </div>
        <div style="height: 20px"></div>
        <div style="text-align: center">
            <input type="checkbox" id="tiaoyue" >
            <label for="tiaoyue">同意并遵守 <a href="#" style="color: #1a7bff">《服务条款》</a></label>
            <input type="checkbox" id="denglu">
            <label for="denglu"> 15天免登录</label>
            <div style="height: 50px"></div>
        </div>
        <div style="position: relative; text-align: center">

            <input type="submit"  value="登陆" class="loing-button">

        </div>
    </div>

</div>


</form>
</body>
<script type="text/javascript">
    function a(ele) {
        ele.style.fontSize="30px";
        ele.style.border="2px solid red";
    }
    function b(ele) {
        ele.style.fontSize="30px";
        ele.style.border="2px solid red";
    }

    var myvar=setInterval(function(){ mytimer()},1000);
    function mytimer() {
        var  d=new Date();
        var  t=d.toLocaleTimeString();
        document.getElementById("demo").innerHTML=t;
    }


</script>

</html>