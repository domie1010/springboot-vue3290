<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${initParam.MyApplicationTitle }</title>
<link rel="stylesheet" type="text/css" href="${basePath}qiantai/resource/css/style.css" />
<!--banner-->
<script type="text/javascript" src="${basePath}qiantai/resource/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="${basePath}qiantai/resource/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="${basePath}qiantai/resource/js/index.js"></script>
</head>

<body>
<!--header-->
<div style="height:95px; background-color:white;">
	<dl class="header">
		<dt><b style="font-size: 30px;">${initParam.MyApplicationTitle }</b></dt>
		<dd></dd>		
	</dl>
</div>

<!--nav-->
<div class="menu">
	<ul class="nav">
		<a href="index-index.action"><li >首页</li></a>
		<c:forEach items="${channels}" var="item">
		
		<a href="index-list.action?id=${item.id }"><li <c:if test="${cid==item.id}">id="dangqian"</c:if> >${item.cname }</li></a>
		</c:forEach>
	</ul>
</div>
<div class="banner1"></div>

<div class="main">
	<div class="inner">
    	<!--菜单-->
        
        <div class="left_nav">
        	<div class="head">
    			<h1><span class="icon"></span></h1>
            </div>
            <div class="con">
                <ul>
                <c:forEach items="${channels}" var="item">
                    <li><a href="index-list.action?id=${item.id }">${item.cname }</a><span class="icon"></li>
                    </c:forEach>
<%--                    <li><jsp:include flush="true" page="/qiantai/page/rili.jsp"></jsp:include></li>--%>
                    <div class="clear"></div>
                </ul>
            </div>
        </div>
        
        <!--产品列表-->
        <div class="right_con">
        	
            <div class="news_box">
                  <ul>
                  	  <c:forEach items="${news}" var="item">
                      <li style=""><a href="index-content.action?id=${item.id }" title="${item.title}" target="_blank">${item.title}</a>&nbsp;&nbsp;&nbsp;<span class="time">${item.createtime}</span></li>
                      <li>&nbsp;</li>
                      </c:forEach>
                  </ul>
                </div>
                <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!--footer-->
<div class="bottom">
	<div class="inner">
      &nbsp;
	</div>
    <div class="ba"><div class="inner"><span class="left">版权所有2015  all rights reserved. 粤icp备 0000000号</span><span class="right"><a href="#">联系我们</a>  |   <a href="admin.action" target="_blank">后台管理</a></span></div></div>
</div>
</body>
</html>




















