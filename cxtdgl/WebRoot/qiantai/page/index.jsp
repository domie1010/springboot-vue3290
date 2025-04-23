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
<script type="text/javascript">
$(document).ready(function(){
	  $("#userLogin").click(function(){
		  $("#userLoginForm").submit();
		  });
	  $("#userloginout").click(function(){
		  window.location="./index-loginout.action"
		});
});
</script>
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
		<a href="index-index.action"><li id="dangqian">首页</li></a>
		<c:forEach items="${channels}" var="item">
		<a href="index-list.action?id=${item.id }"><li>${item.cname }</li></a>
		</c:forEach>
	</ul>
</div>

<!--banner-->
<div class="fullSlide">		
	<div class="bd">
		<ul>
			<li><a href="javascript:void();"><img src="${basePath}qiantai/resource/images/223832142_331627.jpg"></a></li>
			<li><a href="javascript:void();"><img src="${basePath}qiantai/resource/images/20140415180441.jpg"></a></li>
			<li><a href="javascript:void();"><img src="${basePath}qiantai/resource/images/banner.png"></a></li>
		</ul>
	</div>
	<div class="hd"><ul></ul></div>
</div>

	<script type="text/javascript">
		jQuery(".fullSlide").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
	</script>

<!--main-->
<div  class="about">
	<div class="inner">
    	<div class="left">
        	<div class="head">
    			<h1>关于我们</h1><small>ABOUT</small>
            </div>
            <div class="con">
            	<img class="l_img" src="${aboutus.filepath}" />
            	<p>${aboutus.content}</p>
               
                <div class="clear"></div>
            </div>
        </div>
        <div class="right">
        	<div class="head">
    			<h1>用户信息</h1><small>CONTACT</small>
            </div>
            <div class="con">
            	<img src="${basePath}qiantai/resource/images/lxwm.png" />
            	<c:if test="${empty userEntity}">
            	<form id="userLoginForm" action="index-check.action" method="post">
            	<dl>
                	<dt>&nbsp;</dt><dd>&nbsp;${message}&nbsp;</dd>
                    <dt>用户：</dt><dd><input type="text" name="username" value=""/> </dd>
                    <dt>密码：</dt><dd><input type="password" name="password" value=""/></dd>
                    <dt>&nbsp;</dt><dd><a href="#" id="userLogin">登陆</a>&nbsp;</dd>
                </dl>
                </form>
                </c:if>
                <c:if test="${!empty userEntity}">
                <dl>
                	<dt></dt><dd>&nbsp;</dd>
                	<dt></dt><dd>&nbsp;</dd>
                	<dt>用户名：</dt><dd>${loginUser.username }&nbsp;<a href="#" id="userloginout">退出</a></dd>
                    <dt></dt><dd>&nbsp;</dd>
                </dl>
                </c:if>
            </div>
        </div>
    </div>
</div >

<div  class="news">
	<div class="inner">
    	<div class="left">
        	<div class="head">
    			<h1>新闻</h1><small>NEWS</small>
            </div>
            <div class="con">
            	<div class="news_box">
                  <ul>
                  	  <c:forEach items="${news}" var="item">
                      <li style=""><a href="index-content.action?id=${item.id }" title="${item.title}">${item.title}</a><span class="time">${item.createtime}</span></li>
                      
                      </c:forEach>
                  </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="right">
        	<div class="head">
    			<h1>通知公告</h1><small>&nbsp;</small>
            </div>
            <div class="con">
            	<div class="news_box">
                  <ul>
                  	  <c:forEach items="${notes}" var="item">
                      <li style="margin: 5 0 5 0;overflow: hidden; text-overflow:ellipsis;">&nbsp;<a href="index-content.action?id=${item.id }" title="${item.title}">${item.title}</a>&nbsp;</li>
                      </c:forEach>
                  </ul>
                </div>
            </div>
        </div>
    </div>
</div >
<!--footer-->
<div class="bottom">
<div class="inner">
&nbsp;
</div>
    <div class="ba"><div class="inner"><span class="left">版权所有2015  all rights reserved. 粤icp备 0000000号</span><span class="right"><a href="#">联系我们</a>  |   <a href="admin.action" target="_blank">后台管理</a></span></div></div>
</div>
</body>
</html>