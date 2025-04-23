<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("actionEntity","channel");
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
	<li><a href="#">频道维护</a>	</li>
	<li><a href="#">频道修改</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>频道信息维护</span></div>
    <form id="saveUpdateForm" action="<%=basePath%>${actionEntity}-saveUpdate.action" method="post">
    <input type="hidden" name="entity.id" value="${entity.id}" />
    <ul class="forminfo">
    <li><label>频道名称</label><input class="dfinput" type="text" name="entity.cname" id="entitycname" value="${entity.cname}" class="dfinput" data-rule-required="true"/></li>
    
<!--    <li><label>跳转地址</label></li>-->
    <input class="dfinput" type="hidden" name="entity.temppath" id="entitytemppath" value="jwxx.action" class="dfinput" data-rule-required="true"/>
    <li><label>是否显示</label><cite>是：<input type="radio" name="entity.isshow" value="是" <c:if test="${entity.isshow == '是'|| empty entity.isshow}">checked="checked"</c:if> />
    							            否：<input type="radio" name="entity.isshow" value="否" <c:if test="${entity.isshow == '否'}">checked="checked"</c:if>/></cite></li>
    							            
    <li><label>频道类型</label><cite>新闻：<input type="radio" name="entity.ctype" value="新闻" <c:if test="${entity.ctype == '新闻'|| empty entity.ctype}">checked="checked"</c:if> />
    							            公告：<input type="radio" name="entity.ctype" value="公告" <c:if test="${entity.ctype == '公告'}">checked="checked"</c:if>/></cite></li>
    <li><label>频道排序</label><input class="dfinput" type="text" name="entity.csort" id="entitycsort" value="${entity.csort}" class="dfinput" data-rule-digits="true"/></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>

</html>
