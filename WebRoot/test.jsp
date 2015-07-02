<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 引用Jquery的Js文件 -->
	<script type="text/javascript" src="jquery-easyui-1.4.2/jquery-1.4.2.min.js"></script>
	<!-- 引用Easy UI的Js文件 -->
	<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
	<!-- 导入Easy UI的主题css文件 -->
	<link href="jquery-easyui-1.4.2/themes/default/easyui.css" rel="stylesheet" type="text/css">
	<!-- 导入Easy UI的图标Css文件 -->
	<link href="jquery-easyui-1.4.2/themes/icon.css" rel="stylesheet" type="text/css">
	<!-- 引用Easy UI的国际化文件         以下为让它显示中文 -->
	<script type="text/javascript" src="jquery-easyui-1.4.2 /locale/easyui-lang-zh_CN.js"></script>
	<!-- 页面上加上UTF-8编码       防止jquery.easyui.min.js  内容乱码 -->
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
  </head>
  
  <body>
    <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
	    <option value="aa">aitem1</option>   
	    <option>bitem2</option>   
	    <option>bitem3</option>   
	    <option>ditem4</option>   
	    <option>eitem5</option>   
	</select>  

  </body>
</html>
