<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<link /><%--待添加连接--%>
</head>
<body><%------------------用户注册------------------%>
<div class="reg">
	<form action="register" method="post">
		<p>用户注册</p>
		<p><input type="text" name="id" value="" placeholder="请输入工号/学号"><span></span></p>
		<p><input type="text" name="name" value="" placeholder="请输入姓名"><span></span></p>
		<p><input type="text" name="name" value="" placeholder="请输入所属学院"><span></span></p>
		<p><input type="text" name="tel" value="" placeholder="请输入手机号码"><span></span></p>
		<p><input type="text" name="password" value="" placeholder="请输入密码"><span></span></p>
		<p><input type="text" name="rePassword" value="" placeholder="请确认密码"><span></span></p>
		<p>
			<input style="width:15px;height:15px" type="radio" name="identity" value="administrator">管理员
			<input style="width:15px;height:15px" type="radio" name="identity" value="tutor">导师
			<input style="width:15px;height:15px" type="radio" name="identity" value="student">学生
			</p>
		<p><input type="submit" name="" value="注册"></p>
	<p class="txt"><a href="#"><span></span>已有账号登录</a></p>
	</form>
</div>
</body>
</html>