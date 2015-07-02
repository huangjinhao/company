<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/validate.css" rel="stylesheet" type="text/css">
	
	<link href="<%=basePath%>easyuiJs/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>easyuiJs/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>easyuiJs/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/validate.js" type="text/javascript" ></script>
  </head>
  
  <body onload="createCode();">
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="http://demo.dwzjs.com"><img src="<%=basePath%>images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="http://bbs.dwzjs.com">反馈</a></li>
						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="<%=basePath%>images/login_title.png" /></h2>
			</div>
		</div>
			<div id="login_content">
				<div class="loginForm">
					<form action="#">
						<p>
							<label>用户名：</label>
							<input id="userName" class="easyui-validatebox" type="text" size="20" name="name" required="true"></input>
						</p>
						<p>
							<label>密码：</label>
							<input id="psw"  class="easyui-validatebox" type="text" name="psw"  size="20" required="true"></input>
						</p>
						<p>
							<label>验证码：</label>
							<input id="code" type="text" style="width: 40px;" required="true"  class="easyui-validatebox" size="5" />
							<span style="width=75;height=24;"></span>
							<span id="checkCode" onclick="createCode();"></span>
  							<input type="button" class="btnCheck" id="gotoCheck"  value="验证"  onclick="validate();" style="width:40px; height:25px; color:#39F;"/>
						</p>
						<div class="login_bar" >
							<input class="sub" type="submit" value=" " />
						</div>
						<div class="zhuce_bar">
							<input class="sub" type="submit" value=" " />
						</div>
					</form>
				</div>
				<div class="login_banner"><img src="<%=basePath%>images/login_banner.jpg" /></div>
				<div class="login_main">
					<ul class="helpList">
						<li><a href="#">下载驱动程序</a></li>
						<li><a href="#">如何安装密钥驱动程序？</a></li>
						<li><a href="#">忘记密码怎么办？</a></li>
						<li><a href="#">为什么登录失败？</a></li>
					</ul>
					<div class="login_inner">
						<p>您可以使用 网易网盘 ，随时存，随地取</p>
						<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
						<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
					</div>
				</div>
			</div>
			<div id="login_footer">
				Copyright &copy; 2009 www.dwzjs.com Inc. All Rights Reserved.
			</div>
		</div>
	</body>
</html>
