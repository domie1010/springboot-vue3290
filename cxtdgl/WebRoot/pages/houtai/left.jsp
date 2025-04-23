<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resource/theme/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath%>resource/theme/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})
  
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能菜单</div>
	

    
	<c:if test="${session.userEntity.type == 1}">
	
	<dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico01.png" /></span>频道维护</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>channel-list.action" target="rightFrame">频道管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath%>channel-add.action" target="rightFrame">频道添加</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    
    <dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico02.png" /></span>资源维护</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>document-list.action" target="rightFrame">资源管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath%>document-add.action" target="rightFrame">添加资源</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    
    <dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico02.png" /></span>交流中心</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>mess-list.action" target="rightFrame">交流管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath%>mess-add.action" target="rightFrame">添加交流</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    
    <dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico02.png" /></span>日志维护</div>
    <ul class="menuson">
       <li><cite></cite><a href="<%=basePath%>log-list.action" target="rightFrame">日志管理</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    
    
  
    
    </c:if>
    
    

    
    
    
	
    
    <c:if test="${session.userEntity.type == 1}">
    <dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico04.png" /></span>系统管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>user-list.action" target="rightFrame">用户管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath%>user-add.action" target="rightFrame">用户添加</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    </c:if>
    <c:if test="${session.userEntity.type == 2 }">
    <dl class="leftmenu">
    <dd><div class="title"><span><img src="<%=basePath%>resource/theme/images/leftico04.png" /></span>个人信息</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>user-updatepage.action?entity.id=${session.userEntity.id}" target="rightFrame">个人信息维护</a><i></i></li>
    </ul>
    </dd>   
    </dl>
    </c:if>
</body>
</html>
