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
	
	<link href="<%=basePath%>css/register.css" rel="stylesheet" type="text/css" />
	
	<link href="<%=basePath%>easyuiJs/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>easyuiJs/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>easyuiJs/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>

	<script type="text/javascript">
		function win(){
			$("#win").window({
				minimizable:false,
				maximizable:false
			});	
		}
	</script>
  </head>
  
  <body onload="win();" class="easyui-layout" style="font-family: 宋体;overflow-y: hidden" scroll="no"  >   
		<div id="win" class="easyui-window" title="用户注册系统" style="width:900px;height:550px; ">
			<div region="north" split="true" style="overflow: hidden; height: 40px; background: #4E6A80 repeat-x center 50%;
		       padding:15px; color: white; font-size: 25px; ">
		       		<span id="registerHeader">后台注册页面</span>
		    </div>
		    	<form id="form1" action="<%=basePath %>login.action" method="post" >   
				    <div>   
				        <label class="label">账&nbsp;&nbsp;号：</label> 
				        <input class="easyui-validatebox" type="text" name="user.userId" required="true" />   
				    </div>   
				    <br> 
				    <div>   
				        <label class="label">用户名：</label>   
				        <input class="easyui-validatebox" type="text" name="user.password" required="true" />   
				    </div> 
				    <br> 
				    <div>   
				        <label class="label">密&nbsp;&nbsp;码：</label>   
				        <input class="easyui-validatebox" type="text" name="user.name" required="true" />   
				    </div> 
				    <br> 
				    <div>   
				        <label class="label">性&nbsp;&nbsp;别：</label>   
				        <input class="easyui-validatebox" type="text" name="user.sex" required="true"/>   
				    </div>
				    <br>  
				    <div>   
				        <label class="label">年&nbsp;&nbsp;龄：</label>   
				        <input class="easyui-validatebox" type="text" name="user.age" required="true"/>   
				    </div> 
				    <br> 
				    <div>   
				        <label class="label">地&nbsp;&nbsp;址：</label>   
				        <input class="easyui-validatebox" type="text" name="user.address" required="true" />   
				    </div>  
				    <br> 
				    <div>   
				        <label class="label">电&nbsp;&nbsp;话：</label>   
				        <input class="easyui-validatebox" type="text" name="user.tel" required="true" />   
				    </div>  
				    <br> 
				    <div>   
				        <label class="label">邮&nbsp;&nbsp;箱：</label>   
				        <input class="easyui-validatebox" type="text" name="user.email" required="true" />   
				    </div> 
				    <br><br>
				    <div class="login_bar">
						<input class="sub" type="submit" value=" " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=basePath %>jsp/userlogin.jsp"><img style="display: inline;" alt="作废" src="<%=basePath %>images/login_sub.png"></a>
					</div>
				</form>  
		</div> 
		
  </body>
</html>
