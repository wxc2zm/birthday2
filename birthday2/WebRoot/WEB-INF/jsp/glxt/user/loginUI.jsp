<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消费管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>  
  </head>
  <script type="text/javascript">
  	function logins(){
		document.forms[0].submit();
	}

	function setClean(){
		document.getElementById("account").value = "";
		document.getElementById("password").value = "";
	}
  </script>
  <body>
  	<div id="login">
  		<h1>用户登录</h1>
  		<s:form name="form1" namespace="/glxt" action="user_login">
  			<input type="text" id="account" placeholder="用户名" name="user.account"/><em>*</em><br/>
            <label></label><br/><br/>
            <input type="password" id="password" placeholder="密码" name="user.password"/><em>*</em><br/>
            <label></label><br/><br/>
            <a href="#" onClick="javascript:logins();"><button class="but_login">登录</button></a><br/>
            <a href="register.jsp"><button class="but_login">注册</button></a>
            <span><font style="color: red;"><s:property value="loginResult"/></font></span>
 	 	</s:form>
  	</div>
  	 
  </body>
</html>

