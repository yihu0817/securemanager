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
<h3>用户管理 &gt; 用户审核</h3>
<h4>[<a href="listuser">返回</a>]</h4>
<form action="usercheck_submit" method="post" name="form1" id="form1" onsubmit="return validateitem()">
<input type="hidden" name="userid" value="${user.id}">
  <table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr bgcolor="#f0f0f0" height="20">
      <td width="20%"><div align="right"> * 用户名：</div></td>
      <td width="39%"><input name="username" type="text" id="username" size="20" value="${user.name}" readonly/></td>
      <td width="31%">&nbsp;</td>
    </tr>
    <tr bgcolor="#f5f5f5" height="20">
      <td><div align="right">* 密码：</div></td>
      <td><input name="password" type="password" id="password" size="20" value="${user.password}" readonly/></td>
      <td><label></label></td>
    </tr>
    <tr bgcolor="#f0f0f0" height="20">
      <td><div align="right">*角色：</div></td>
      <td><label>
        <select name="roleId">
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
      </label></td>
      <td>&nbsp;</td>
    </tr>
    <tr bgcolor="#f5f5f5" height="20">
      <td><div align="right">状态：</div></td>
       <td>
       <select name="state" id="state">
       <c:if test="${user.state == 1}">
          <option value="1" selected="selected">通过</option>
          <option value="0">未通过</option>
      	</c:if>
      	 <c:if test="${user.state == 0}">
          <option value="0" selected="selected">未通过</option>
          <option value="1">通过</option>
      	</c:if>
        </select></td>
      <td><label></label></td>
    </tr>
    
 
    <tr bgcolor="#f5f5f5" height="20">
      <td>&nbsp;</td>
      <td colspan="2"><input name="submit" type="submit"  value="提交" />
          <input name="submit2" type="reset"  value="重置" /></td>
    </tr>
  </table>
</form>
<table width="100%"  border="0" cellpadding="1" cellspacing="1">
  <tr bgcolor="#f5f5f5" height="20">
    <td height="30" bgcolor="#FFFFFF"><em>注意:名称前有*的为必填项</em></td>
  </tr>
</table>


</body>
</html>