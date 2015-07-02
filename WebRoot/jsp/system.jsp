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
 	
 	<script src="<%=basePath %>js/system.js" type="text/javascript"></script>
  	
  	<script type="text/javascript">
       $(document).ready(function(){
	    	$("#stuBrith").datebox({
	    		required:true
	    	});
    	});
    	function formatD(date){
    	return date.getFullYear()+"-"+date.getMonth()+"-"+date.getDay();
    	}
    </script>
  </head>
  
  <body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	   
	    <div region="center" style="width: 500px; height: 300px; padding: 1px;overflow-y: hidden">
	        <div id="test" >
	        </div>
	    </div>
	    
	    <!-- 使用Javascript创建对话框窗口也是允许的 -->
	    <div id="Dlg-Edit" title="编辑窗口" style="width: 440px; height: 300px;">
	        <div style="padding: 20px 20px 40px 80px;">
	            <form method="post">
		            <table>
		                <tr>
		                    <td style="width:120px;">
		                                                          名称：
		                    </td>
		                    <td>
		                        <input id="stuName" name="stuName" class="easyui-validatebox" required="true" style="width: 200px;"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="width:120px;">
		                                                          性别：
		                    </td>
		                    <td>
		                        <select name="stuSex" style="width: 200px;">
		                           <option value="男">男</option>
		                           <option value="女">女</option>
		                        </select>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="width:120px;">
		                                                          出生日期：
		                    </td>
		                    <td>
		                        <input id="stuBrith" name="stuBrith" class="easyui-validatebox" required="true" style="width: 200px;"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="width:120px;">
		                                                          电子邮箱：
		                    </td>
		                    <td>
		                        <input id="stuMail" name="stuMail" class="easyui-validatebox" required="true" style="width: 200px;"/>
		                    </td>
		                </tr>
		            </table>
	            </form>
	        </div>
	    </div>
	</body>
</html>
