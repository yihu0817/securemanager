<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<div align="center" >
		<h2><a href="login">返回登录界面</a></h2>
		<h3>用户注册</h3>
		<form action="register_submit" method="POST">
			用户名: <input type="text" name="name" /><br> 
			密      码: <input type="password" name="password" /><br><br> 
			<input type="submit" value="提交">
			<br>
			${message }
		</form>
	</div>
</body>
</html>