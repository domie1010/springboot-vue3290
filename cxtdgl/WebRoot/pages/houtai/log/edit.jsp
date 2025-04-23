<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("actionEntity","log");
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
    <li><a href="#">首页</a>	</li>
	<li><a href="#">一级菜单</a>	</li>
	<li><a href="#">二级菜单</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>模块名称</span></div>
    <form id="saveUpdateForm" action="<%=basePath%>${actionEntity}-saveUpdate.action" method="post">
    <input type="hidden" name="entity.id" value="${entity.id}" />
    
        <ul class="forminfo">
    	<li><label>id</label><input id="entityid" class="dfinput" type="text" name="entity.id"  value="${ entity.id}" data-rule-required="true"/></li>
		<li><label>userid</label><input id="entityuserid" class="dfinput" type="text" name="entity.userid"  value="${ entity.userid}" data-rule-required="true"/></li>
		<li><label>username</label><input id="entityusername" class="dfinput" type="text" name="entity.username"  value="${ entity.username}" data-rule-required="true"/></li>
		<li><label>message</label><input id="entitymessage" class="dfinput" type="text" name="entity.message"  value="${ entity.message}" data-rule-required="true"/></li>
		<li><label>createtime</label><input id="entitycreatetime" class="dfinput" type="text" name="entity.createtime"  value="${ entity.createtime}" data-rule-required="true"/></li>
	    
    
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>
</html>
