<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
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
  	<script src="<%=basePath%>easyuiJs/plugins/jquery.datebox.js" type="text/javascript"></script>
 	
 	<script type="text/javascript">
 		$('#test').datagrid({    
		    url:'datagrid_data.json',    
		    columns:[[    
		        {field:'code',title:'Code',width:100},    
		        {field:'name',title:'Name',width:100},    
		        {field:'price',title:'Price',width:100,align:'right'}    
		    ]]    
		});  
 	</script>
  </head>
  
  <body class="easyui-layout" style="overflow-y: hidden" scroll="no">
  	    <div region="center" style="width: 500px; height: 300px; padding: 1px;overflow-y: hidden">
	        <div id="test" >
	        	
	        </div>
	    </div>
  </body>
</html>
