<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resource/theme/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath%>resource/theme/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	$("#logout").click(function(){
		if(window.confirm('您确定要退出吗？')) {
	        top.location = '<%=basePath%>login-loginout.action';
	    }
	})	
})	
</script>
</head>

<body style="background:url(<%=basePath%>resource/theme/images/topbg.gif) repeat-x;">
    <div class="topleft">
    	<div style="margin-top: 20px;margin-left: 20px;">
    		<b style="font-weight: bold;font-size: 25px;color: white;">${initParam.MyApplicationTitle }</b>
    	</div>
    </div>    
    <div class="topright">    
    <ul>
    <li><a href="javascript:void();" target="_parent" id="logout">退出</a></li>
    </ul>
    <div class="user">
    <span><c:if test="${session.userEntity.type == '1'}">管理员</c:if><c:if test="${session.userEntity.type == '2'}">警务员</c:if>&nbsp;${session.userEntity.username} 您好！</span>  
    </div>    
    </div>
</body>
</html>
