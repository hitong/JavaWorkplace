<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这里是标题</title>
<link href="css/page.css" rel="stylesheet"/>
<link href="css/common.css" rel="stylesheet"/>
<style type="text/css">

/*为了降低初学的难度，我尽量的不用 css，javascript 。但是 我也会引入一些(毕竟做web,写网站离不开这些东西)，在引入的地点我都有详细的说明*/
.loginform{
	/*这是css。这段代码的作用是让 class属性为 loginform 的 元素水平垂直居中。很经典的代码 */	
	position: absolute;
	width:400px;
	height: 250px;
	top:50%;
	left:50%;
	margin-top: -125px;
	margin-left: -200px;
	/*设置边框*/
	border: 1px solid #8a8a8a;
}

/*给页面设置背景颜色*/
body{
	background-color: #e5e5e5;
}

</style>
</head>
<body>

	<a href="#">前台首页</a>
	<hr/>
	
	
	<div class="loginform">
	
		<form action="admin/AdminLogin" method="post">
			<br>
			<p class="logintitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员登录</font></p>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;<label for="accountField">登录帐号:</label> <input type="text" name="account" value="${account}" id="accountField"/> <font color="red">${accountMessage}</font><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;<label for="passwordField">登录密码:</label> <input type="password" name="password" id="passwordField"/> <font color="red">${passwordMessage}</font><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录"/>
		</form>
		
	</div>
	
</body>
</html>