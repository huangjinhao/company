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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#checkHP{
			float: left;
		}
		
		#checkCode { 
			float:left; 
			width:60px; 
			height:15px; 
			padding: 0px 0px; 
			color:red; 
			font-size:16px; 
			font-family:Arial; 
			font-style:italic; 
			color:Red; 
			border:0; 
			padding:2px 0px; 
			letter-spacing:1px; 
			font-weight:bolder; 
		}
		
		.text { 
			font-size: 16px; 
			color: #F00;
		}
	</style>
	<script language="javascript" type="text/javascript">
		var code="" ; 
		function createCode(){ 
			code = "";
			var codeLength = 6;
			var checkCode = document.getElementById("checkCode");
			checkCode.value = "";
			var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
			for(var i=0;i<codeLength;i++) {   
				var charIndex = Math.floor(Math.random()*32);   
				code +=selectChar[charIndex];
			}
			if(code.length != codeLength){   
				createCode();
			}
			document.getElementById("checkCode").innerHTML = code;
		}
		function validate () {
			var inputCode = document.getElementById("checkNum").value.toUpperCase();
			if(inputCode.length <=0) {   
				alert("请输入验证码！");   
				return false;
			}else if(inputCode != code ){   
				alert("验证码输入错误！");   
				createCode();   
				return false;
			}else {  
				alert("验证码通过！");   
				return true;
			}
		}
	</script>
  </head>
  
  <body onload="createCode();" bgcolor="#33CCFF">
  	<table width="521" height="37" align="center">
  		<tr>
  			<td width="40">
  				<div id="checkHR">
  					<span class="text">请输入验证码：</span>  
  					<input type="text" value="" id="checkNum" style="width:55px;"/>
  				</div>
  			</td>
  			<td width="30">
  				<div id="checkCode" onclick="createCode();"></div>
  				<input type="button" class="btnCheck" id="gotoCheck"  value="验证"  onclick="validate();" style="width:50px; height:25px; color:#39F;"/>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
