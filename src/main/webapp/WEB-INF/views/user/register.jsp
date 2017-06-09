<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div>

		<a href="login">返回登录</a>

		<h3>用户注册</h3>

		<form role="form" action="register_submit" method="POST">
			<div class="form-group">
				<label>用户名:</label><input type="text" name="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label>密&nbsp;&nbsp;码:</label> <input type="password" name="password" class="form-control"/>
			</div>
			<input type="submit" value="提交" class="btn btn-default"> ${message }
		</form>
	</div>
</html>