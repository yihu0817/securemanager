<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" href="<%=contextPath%>/static/css/pintuer.css">
<link rel="stylesheet" href="<%=contextPath%>/static/css/admin.css">
<script src="<%=contextPath%>/static/js/jquery.js"></script>
<script src="<%=contextPath%>/static/js/pintuer.js"></script>
<script type="text/javascript">

	$(function(){
		$("#submitBtn").click(function(){
			$.ajax({
				data : "name=" + $("#name").val()+"&"+"password="+${"#password"}.val(),
				type : "GET",
				dataType : "json",
				url : "<%=contextPath%>/login_submit.do",
				error : function(data) {
					alert("出错了！！:" + data.msg);
				},
				success : function(data) {
					alert("success:" + data.msg);
					//$("#error").html(data.msg);
				}
			});
		});
	});
	
	<%-- $.ajax({
		data : "name=" + $("#name").val()+"&"+"password="+${"#password"}.val(),
		type : "GET",
		dataType : "json",
		url : "<%=contextPath%>/login_submit.do",
		error : function(data) {
			alert("出错了！！:" + data.msg);
		},
		success : function(data) {
			alert("success:" + data.msg);
			//$("#error").html(data.msg);
		}
	}); --%>
</script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="<%=contextPath%>/login_submit" method="POST"> 
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="name" id="name"
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password" id="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>

							<div>${message}</div>
						</div>
						<div style="padding: 30px;">
							<input type="submit" id="submitBtn"
								class="button button-block bg-main text-big input-big"
								value="登录" onclick="javascript:ajaxTest();">
							
							<a href="<%=contextPath%>/register">[注册]</a>
							
						</div>
					</div>
				</form>


			</div>
		</div>
	</div>

</body>
</html>