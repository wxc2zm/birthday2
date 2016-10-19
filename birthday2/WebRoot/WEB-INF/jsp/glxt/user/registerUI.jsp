<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消费管理系统</title>
<link rel="stylesheet" type="text/css" href="css/index.css"/> 
<script src="jquery/jquery-3.1.0.min.js"></script>
<script src="jquery/jquery.validate.js"></script>
<script src="jquery/messages_zh.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script>
	$.validator.addMethod("specialCharValidate", function(value, element) {
		var pttern = new RegExp("['~!@#$%^&()-=+|{};:\"\\<>/?\.,￥【】（）“”。，、？]");
		alert(this.optional(element));
		alert(!pattern.test(value));
		return this.optional(element) || !pattern.test(value);
		
	},"禁止输入非法字符");
	$().ready(function() {
		
		$("#myform").validate({
			debug: true,
			onkeyup: null,
			rules: {
				"user.username": {
					required: true,
					minlength: 3,
					remote: {
						url: "user_checkUserName.action",
						type: "post",
						}
						
					},
				"user.password": {
					required: true,
					minlength: 3
					},
				password:{
					required: true,
					equalTo: "#password1"
					}
			},
			messages: {
				"user.username": {
					required: "请输入用户名",
					minlength: "不能少于3个字符",
					remote: "用户名已存在"
					},
				"user.password": {
					required: "请输入密码",
					minlength: "不能少于3个字符"
					},
				password:{
					required: "请重新输入密码",
					equalTo: "两次输入的密码不一致"
					}
			},
			errorplacement: function(error, element) {
				error.appendto(element.next("label"));
			}
		});
	});
</script>
<style>
.error {
	color:red;
}
</style>
</head>

<body>
	<div id="register">
		<h1>用户注册</h1>
		<s:form action="user_register" method="post" id="myform">
			<font>用户名：</font><input type="text" id="username" name="user.username"/><em>*</em><br/>
			  <label></label><br/><br/>
			
            <font>密　码：</font><input  type="password" id="password1" name="user.password"/><em>*</em><br/>
            <label></label><br/><br/>
            
            <font>确认密码：</font><input  type="password"  id="password2" name="password"/><em>*</em><br/>
            <label></label><br/><br/>
            
            <button class="but_reighter" type="submit">注册</button><br/>
           <!--  <font style="{}">已有账号！<a href="index.jsp">去登录</a> -->
		</s:form>
	</div>
</body>
</html>