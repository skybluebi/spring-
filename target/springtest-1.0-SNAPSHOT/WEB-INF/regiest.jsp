<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/2
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
  function changeCode() {
      alert("fjaj");
    var imgSrc=$("#img").attr("src");
    $("#img").attr("src",imgSrc.toString()+"?timestamp="+new Date().valueOf().toString())
  }
</script>
<body>
<form action="/regist" method="post">
    用户名：<input name="username"><br/>
    密码：<input name="password"><br/>
    验证码:<input name="code">
    <img id="img"src="/proCode" onclick="changeCode()"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
