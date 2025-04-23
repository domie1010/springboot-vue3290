<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("actionEntity","mess");
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
	<li><a href="#">交流中心</a>	</li>
	<li><a href="#">添加交流</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>添加交流</span></div>
    <form id="saveUpdateForm" action="<%=basePath%>${actionEntity}-saveUpdate.action" method="post">
    <input type="hidden" name="entity.id" value="${entity.id}" />
    
        <ul class="forminfo">
<%--    	<li><label>id</label><input id="entityid" class="dfinput" type="text" name="entity.id"  value="${ entity.id}" data-rule-required="true"/></li>--%>
<%--		<li><label>fuserid</label><input id="entityfuserid" class="dfinput" type="text" name="entity.fuserid"  value="${ entity.fuserid}" data-rule-required="true"/></li>--%>
		<li><label>提问人</label><input id="entityfusername" class="dfinput" type="text" name="entity.fusername"  value="${ entity.fusername}" data-rule-required="true"/></li>
		<li><label>提问内容</label><input id="entityfmessage" class="dfinput" type="text" name="entity.fmessage"  value="${ entity.fmessage}" data-rule-required="true"/></li>
<%--		<li><label>tuserid</label><input id="entitytuserid" class="dfinput" type="text" name="entity.tuserid"  value="${ entity.tuserid}" data-rule-required="true"/></li>--%>
		<li><label>回复人</label><input id="entitytusername" class="dfinput" type="text" name="entity.tusername"  value="${ entity.tusername}" data-rule-required="true"/></li>
		<li><label>回复内容</label><input id="entitytmessage" class="dfinput" type="text" name="entity.tmessage"  value="${ entity.tmessage}" data-rule-required="true"/></li>
<%--		<li><label>ext1</label><input id="entityext1" class="dfinput" type="text" name="entity.ext1"  value="${ entity.ext1}" data-rule-required="true"/></li>--%>
<%--		<li><label>ext2</label><input id="entityext2" class="dfinput" type="text" name="entity.ext2"  value="${ entity.ext2}" data-rule-required="true"/></li>--%>
<%--		<li><label>ext3</label><input id="entityext3" class="dfinput" type="text" name="entity.ext3"  value="${ entity.ext3}" data-rule-required="true"/></li>--%>
<%--		<li><label>createtime</label><input id="entitycreatetime" class="dfinput" type="text" name="entity.createtime"  value="${ entity.createtime}" data-rule-required="true"/></li>--%>
	    
    
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>
</html>
