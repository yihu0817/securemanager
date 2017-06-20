<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<%=contextPath%>/static/bootstrap/bootstrap.min.css">
<script src="<%=contextPath%>/static/js/jquery.js"></script>
<script src="<%=contextPath%>/static/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<h3>用户信息管理</h3>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>审核状态</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${userLists}" var="x">

			<tr>
				<td>${x.id}</td>
				<td>${x.name}</td>
				<td>********</td>
				<c:if test="${x.state == 1}">
					<td>通过</td>
				</c:if>
				<c:if test="${x.state == 0}">
					<td>未通过</td>
				</c:if>
				<td><a class="btn btn-default"
					href="javascript:void _delete('deleteuser.jspa?userid=${x.id}','此用户')">删除</a>
					<a class="btn btn-default"
					href="checkuser?userid=${x.id}">审核</a></td>
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>