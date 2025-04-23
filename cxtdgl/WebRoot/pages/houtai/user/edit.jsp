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
    <li><a href="#">用户编辑</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <form id="saveUpdateForm" action="<%=basePath%>user-saveUpdate.action" method="post">
    <input type="hidden" name="entity.id" value="${entity.id}" />
    <ul class="forminfo">
    <li><label>用户名</label><input class="dfinput" type="text" name="entity.username" id="entityusername" value="${entity.username}" class="dfinput" data-rule-required="true"/></li>
    <li><label>性别</label><cite>男：<input type="radio" name="entity.sex" value="1" <c:if test="${entity.sex == '1' || empty entity.sex}">checked="checked"</c:if> />
    							女：<input type="radio" name="entity.sex" value="2" <c:if test="${entity.sex == '2'}">checked="checked"</c:if>/></cite></li>
    <li><label>年龄</label><input class="dfinput" type="text" name="entity.age" id="entityage" value="${entity.age}" class="scinput" data-rule-required="true" data-rule-digits="true" data-rule-max="130" data-rule-min="18" data-msg-max="年龄必须在18岁到130岁之间!" data-msg-min="年龄必须在18岁到130岁之间!"/> </li>
    <li><label>密码</label><input class="dfinput" type="password" name="entity.password" id="entitypassword" value="${entity.password}" class="scinput" data-rule-required="true"/></li>
    <li><label>邮件地址</label><input class="dfinput" type="text" name="entity.email" id="entityemail" value="${entity.email}" class="scinput" data-rule-required="true" data-rule-email="true"/></li>
    <li><label>是否禁用</label><cite>是：<input type="radio" name="entity.isenable" value="1" <c:if test="${entity.isenable == '1' || empty entity.isenable}">checked="checked"</c:if> />
									否：<input type="radio" name="entity.isenable" value="0" <c:if test="${entity.isenable == '0'}">checked="checked"</c:if>/></cite></li>
									
									
	<li><label>用户角色</label><cite>管理员：<input type="radio" name="entity.type" value="1" <c:if test="${entity.type == '1' || empty entity.type}">checked="checked"</c:if> />
							  		  普通用户：<input type="radio" name="entity.type" value="2" <c:if test="${entity.type == '2'}">checked="checked"</c:if>/>
<%--							  		工资调整：<input type="radio" name="entity.type" value="3" <c:if test="${entity.type == '3'}">checked="checked"</c:if>/>--%>
<%--							  		工资查询：<input type="radio" name="entity.type" value="4" <c:if test="${entity.type == '4'}">checked="checked"</c:if>/></cite>--%>
									</li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>

</html>
