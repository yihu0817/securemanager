<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户信息管理</h3>
	<table width="80%" border="0" cellpadding="2" cellspacing="2"
		bgcolor="#cccccc">
		<tr>
			<td width="10%"><div align="center">序号</div></td>
			<td width="30%"><div align="center">用户名</div></td>
			<td width="20%"><div align="center">密码</div></td>
			<td width="20%"><div align="center">审核状态</div></td>
			<td width="20%"><div align="center">操作</div></td>
		</tr>
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${userLists}" var="x">
			<%
				if (c == 1) {
						color = "#ffffff";
						c = 0;
					} else {
						color = "#f5f5f5";
						c = 1;
					}
			%>
			<tr>
				<td bgcolor="#FFFFFF"><div align="center">${x.id}</div></td>
				<td bgcolor="#FFFFFF">
					<div align="center">${x.name}</div>
				</td>
				<td bgcolor="#FFFFFF">
					<div align="center">********</div>
				</td>
				<c:if test="${x.state == 1}">
					<td bgcolor="#FFFFFF"><div align="center">通过</div></td>
				</c:if>
				<c:if test="${x.state == 0}">
					<td bgcolor="#FFFFFF"><div align="center">未通过</div></td>
				</c:if>

				<td bgcolor="#FFFFFF"><div align="center">
						[<a
							href="javascript:void _delete('deleteuser.jspa?userid=${x.id}','此用户')">删除</a>]
						[<a href="checkuser?userid=${x.id}">审核</a>]
					</div>
			</tr>
		</c:forEach>
	</table>


</body>
</html>