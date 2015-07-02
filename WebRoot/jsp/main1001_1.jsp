<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公司管理主页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=basePath%>css/main1001.css" rel="stylesheet" type="text/css">
	<script src="<%=basePath%>js/main1001.js" type="text/javascript"></script>
	
	<link href="<%=basePath%>easyuiJs/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>easyuiJs/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>easyuiJs/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>easyuiJs/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
  
  	<script type="text/javascript">
	    $(function () {
	    	InitLeftMenu();
	    	$('body').layout();
	    });
	
	    function InitLeftMenu() {
	    	$('.easyui-accordion li a').click(function () {
	    		var tabTitle = $(this).text();
	    		var url = $(this).attr("href");
	    		addTab(tabTitle, url);
	    		$('.easyui-accordion li div').removeClass("selected");
	    		$(this).parent().addClass("selected");
	    	}).hover(function () {
	    		$(this).parent().addClass("hover");
	    	}, function () {
	    		$(this).parent().removeClass("hover");
	    	});
	    }
	
	    function addTab(subtitle, url) {
	    	if (!$('#tabs').tabs('exists', subtitle)) {
	    		$('#tabs').tabs('add', {
	    			title: subtitle,
	    			content: createFrame(url),
	    			closable: true,
	    			width: $('#mainPanle').width() - 10,
	    			height: $('#mainPanle').height() - 26
	    		});
	    	} else {
	    		$('#tabs').tabs('select', subtitle);
	    	}
	    }
	
	    function createFrame(url) {
	    	var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	    	return s;
	    }
	  </script>
  </head>
  
  <body onload="createTime()" class="easyui-layout" style="overflow-y: hidden" scroll="no" >
  	<noscript>
        <div id="noscript">
            <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
        </div>
    </noscript>
    <div region="north" split="true" style="overflow: hidden; height: 60px; background: #4E6A80 repeat-x center 50%;
       padding:15px; color: white; font-size: 17px;">
       		<span id="headerword">欢迎使用公司管理系统</span>
        	<span class="commsouth"><a href="#" style="color: white">退出</a></span>
        	<span class="commsouth"><a href="<%=basePath%>jsp/userlogin.jsp" style="color: white">登录页面</a></span>
        	<span class="commsouth" id="time"></span>
        	<span class="commsouth" id="date"></span>
        	<span class="commsouth">欢迎您登录！</span>
    </div>
    <div  style="width: 100% ; height: 30px;">欢迎使用公司管理系统</div>
    <div id="south" region="south" style="height: 20px; background: #D2E0F2;">
        <div id="southdiv"> EntWebSite ver 1.0</div>
    </div>
    
    <div region="west" split="true" title="导航菜单" style="width: 180px;overflow:hidden;" icon="icon-redo">
        <div id="menu" class="easyui-accordion" fit="true" border="false">
            <div title="系统管理" style="overflow:auto; padding: 10px;" icon="icon-edit">
                <ul class="easyui-tree">
            		<li>
            			<span>公司部门</span>
	            		<ul>
	            			<li>
	            				<span>
	            					<a class="treeA" target="mainFrame" href="<%=basePath%>jsp/system.jsp">公司制度</a>
	            				</span>
	            			</li>
	            			<li>
	            				<span>
	            					<a class="treeA" target="mainFrame" href="#">公司信息</a>
	            				</span>
	            			</li>
	            		</ul>
            		</li>
            		<br/>
            		<li>
            			<span>公司部门</span>
	            		<ul>
	            			<li>
	            				<span>
	            					<a class="treeA" target="mainFrame" href="#">公司制度</a>
	            				</span>
	            			</li>
	            			<li>
	            				<span>
	            					<a class="treeA" target="mainFrame" href="#">公司信息</a>
	            				</span>
	            			</li>
	            		</ul>
            		</li>
            		
            	</ul>
            </div>
            <div title="部门管理" style="padding: 10px;" icon="icon-edit">
            	<ul class="easyui-tree">
            		<li>ee</li>
            	</ul>
            </div>
            <div title="栏目管理" style="padding: 10px;" icon="icon-edit">
                <ul class="easyui-tree">
            		<li>rr</li>
            	</ul>
            </div>
            <div title="帮助信息" icon="icon-help">
                <h4>
                    EntWebSite Ver 1.0</h4>
            </div>
        </div>
    </div>
    <div region="center" id="mainPanle" style="background: #eee;overflow:hidden;">
        <div id="tabs" class="easyui-tabs" fit="true" border="false">
            <div title="主页" style="padding: 20px;" id="home">
                <h1>
                    Welcome...</h1>
            </div>
        </div>
    </div>
  </body>
</html>
