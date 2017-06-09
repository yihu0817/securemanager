<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户审核</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>用户管理 &gt; 用户审核</h3>
	<h4>
		[<a href="listuser">返回</a>]
	</h4>

	<form class="form-horizontal" action="usercheck_submit" method="post"
		name="form1" id="form1" onsubmit="return validateitem()">

		<input type="hidden" name="userid" value="${user.id}">
		<div class="form-group">
			<label class="col-sm-2 control-label">* 用户名:</label>
			<div class="col-sm-offset-2 col-sm-10">
				<input name="username" type="text" class="form-control"
					id="username" size="20" value="${user.name}" readonly />
			</div>
		</div>



		<div class="form-group">
			<label class="col-sm-2 control-label">* 密&nbsp;&nbsp;码:</label>
			<div class="col-sm-offset-2 col-sm-10">
				<input name="password" type="password" class="form-control"
					id="password" size="20" value="${user.password}" readonly />
			</div>
		</div>


		<div class="form-group">
			<label class="col-sm-2 control-label">* 角&nbsp;&nbsp;色:</label>
			<div class="col-sm-offset-2 col-sm-10">
				<select name="roleId" class="form-control">
					<option value="1"></option>
					<c:forEach items="${roleList}" var="x">
						<c:if test="${x.rId == user.role.rId}">
							<option value="${x.rId}" selected="selected">${x.name}</option>
						</c:if>
						<c:if test="${x.rId != user.role.rId}">
							<option value="${x.rId}">${x.name}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">&nbsp;&nbsp;状&nbsp;&nbsp;态:</label>
			<div class="col-sm-offset-2 col-sm-10">
				<select name="state" id="state" class="form-control">
					<c:if test="${user.state == 1}">
						<option value="1" selected="selected">通过</option>
						<option value="0">未通过</option>
					</c:if>
					<c:if test="${user.state == 0}">
						<option value="0" selected="selected">未通过</option>
						<option value="1">通过</option>
					</c:if>
				</select>
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input name="submit" type="submit" value="提交"
					class="btn btn-default" /> <input name="submit2" type="reset"
					value="重置" class="btn btn-default" />
					<br><br><br><em>注意:名称前有*的为必填项</em>
			</div>
		
		</div>

	</form>





</body>
</html>