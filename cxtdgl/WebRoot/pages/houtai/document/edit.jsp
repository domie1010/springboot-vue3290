<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("actionEntity","document");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>resource/theme/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>resource/javascript/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/javascript/messages_zh.js"></script>
<link rel="stylesheet" href="<%=basePath%>resource/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="<%=basePath%>resource/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="<%=basePath%>resource/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 $("#saveUpdateForm").validate({debug:false});
});
KindEditor.ready(function(K) {
 	K.create('#entitycontent', {
 		allowFileManager : true,
 		uploadJson:'<%=basePath%>/servlet/KindeditorUpload',
 		fileManagerJson:'<%=basePath%>/servlet/KindeditorFileManager'
 	});
 });
</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a>	</li>
	<li><a href="#">资源维护</a>	</li>
	<li><a href="#">资源编辑</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>信息维护</span></div>
    <form id="saveUpdateForm" action="<%=basePath%>${actionEntity}-saveUpdate.action" method="post" enctype="multipart/form-data">
    <input type="hidden" name="entity.id" value="${entity.id}" />
    <input type="hidden" name="entity.filepath" value="${entity.filepath}" />
    <ul class="forminfo">
    <li><label>资源标题</label><input class="dfinput" type="text" name="entity.title" id="entitytitle" value="${entity.title}" class="dfinput" data-rule-required="true"/></li>
    <li><label>资源摘要</label><input class="dfinput" type="text" name="entity.summary" id="entitysummary" value="${entity.summary}" class="dfinput" data-rule-required="true"/></li>
    <li><label>所属频道</label>
    <select class="dfinput" name="entity.channel" data-rule-required="true">
    <c:forEach items="${channel}" var="item">
    	<option value="${item.id}" <c:if test="${item.id==entity.channel}">selected="selected"</c:if>>${item.cname}</option>
    </c:forEach>
    </select>
    </li>
    <li><label>资源附件</label><input class="dfinput" type="file" name="image" id="entityanswer" value=""/><c:if test="${!empty entity.filepath}"><a href="${entity.filepath}" target="_blank">浏览</a></c:if></li>
    <li><label>是否置顶</label><cite>是：<input type="radio" name="entity.istop" value="是" <c:if test="${entity.istop == '是'}">checked="checked"</c:if> />
    							           否：<input type="radio" name="entity.istop" value="否" <c:if test="${entity.istop == '否' || empty entity.istop}">checked="checked"</c:if>/></cite></li>
    
    <li><label>资源内容</label>
    </li>
    <li>
    <textarea id="entitycontent" name="entity.content" style="width:800px;height:400px;visibility:hidden;" data-rule-required="true">${entity.content}</textarea>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>
</html>
