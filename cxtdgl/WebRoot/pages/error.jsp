<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resource/theme/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>resource/javascript/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/javascript/messages_zh.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 $("#saveUpdateForm").validate({debug:false});
});
</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">系统管理</a></li>
    <li><a href="#">系统错误</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>错误消息</span></div>
   	<h1><s:property value="exception.message"/></h1><BR>
	<s:debug></s:debug>
    </div>
</body>

</html>
