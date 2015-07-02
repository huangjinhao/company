<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link href="<%=basePath%>easyuiJs/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>easyuiJs/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>easyuiJs/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/validate.js" type="text/javascript" ></script>

  </head>
  
  <body style="padding: 0">   

  </body>
</html>
