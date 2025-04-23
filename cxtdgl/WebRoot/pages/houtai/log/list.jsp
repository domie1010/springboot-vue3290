<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	request.setAttribute("actionEntity","log");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=basePath%>resource/theme/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=basePath%>resource/theme/js/jquery.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		  $(".click").click(function(){
		  $(".tip").fadeIn(200);
		  });

		  $(".find").click(function(){
			 $("#listform").submit(); 
		  });
		  
		  $(".tiptop a").click(function(){
		  $(".tip").fadeOut(200);
		});
		
		  $(".sure").click(function(){
			window.location= "./${actionEntity}-delete.action?entity.id=" + $(".sure_value").val();;
		  $(".tip").fadeOut(100);
		});
		
		  $(".cancel").click(function(){
		  $(".tip").fadeOut(100);
		});
		});
		function delete_confirm(e,id){
			$(".tip").fadeIn(200);
			$(".sure_value").val(id);
		}
		function gotoPage(page){
			$("#pageNo").val(page);
			$("#listform").submit(); 
		}
		</script>
	</head>
	<body>
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li><a href="#">首页</a>	</li>
					<li><a href="#">日志管理</a>	</li>
					<li><a href="#">日志列表</a></li>
				</ul>
			</div>
			<form action="<%=basePath%>${actionEntity}-list.action" method="post" id="listform">
			<div class="rightinfo">
				<div class="tools">
					<ul class="toolbar">
						<li style="padding-right: 0px;">
						  &nbsp;&nbsp; 用户名：<input type="text" name="entity.username" class="dfinput">
						</li>
						<li class="find">
							<span><img src="<%=basePath%>resource/theme/images/t06.png" /> </span>查询
						</li>
					</ul>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
						
														
														<th>用户名</th>
														<th>操作IP</th>
														<th>操作</th>
														<th>操作时间</th>
							<c:if test="${session.userEntity.type == '1'}">				
							<th width="150px">操作</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<s:if test="#request.list!=null">
							<s:iterator value="list">
								<tr>
								
																		
																		<td><s:property value="username" /></td>
																		<td><s:property value="opip" /></td>
																		<td><s:property value="message" /></td>
																		
									<td>
										<s:date name="createtime" format="yyyy-MM-dd" />
									</td>
									<c:if test="${session.userEntity.type == '1'}">
									<td>
										<a class="tablelink" href="javascript:delete_confirm(this,'<s:property value="id" />')">【 删除】</a>
									</td>
									</c:if>
								</tr>
							</s:iterator>
						</s:if>
					</tbody>
				</table>

								<div class="pagin">
					<div class="message">
						共<i class="blue">${ pageUtil.totalRecord}</i>条记录，当前显示第&nbsp;
						显示第<i class="blue">${ pageUtil.currentStartRecord}</i>到<i class="blue">${pageUtil.currentEndRecord}</i>条记录
					</div>
					 <ul class="paginList">
				       	<c:if test="${ pageUtil.currentPage == '1'}">
							<li class="paginItem"><a href="javascript:;">首页</a></li>
						</c:if>
						<c:if test="${ pageUtil.currentPage != '1'}">
							<li class="paginItem">
								<a href="javascript: gotoPage('1')">首页</a>
							</li>
						</c:if>
						<c:if test="${ pageUtil.currentPage != '1'}">
							<li class="paginItem">
								<a href="javascript: gotoPage('${pageUtil.upPage}')">上一页</a>
							</li>
						</c:if>
						<li class="paginItem more">
							<a  href="javascript:;"><input name="currentPage" id="pageNo" type="text" value="${pageUtil.currentPage}" size="3" style="width: 30px;height: 28px;" align="middle"/></a>
						</li>
						<c:if test="${ pageUtil.currentPage != pageUtil.totalPage}">
							<li class="paginItem">
								<a href="javascript: gotoPage('${pageUtil.downPage}')">下一页</a>
							</li>
						</c:if>
						<c:if test="${ pageUtil.currentPage != pageUtil.totalPage}">
							<li class="paginItem">
								<a href="javascript: gotoPage('${pageUtil.totalPage}')">尾页</a>
							</li>
						</c:if>
						<c:if test="${ pageUtil.currentPage == pageUtil.totalPage}">
							<li class="paginItem">
								<a href="javascript:;">尾页</a>
							</li>
						</c:if>
			        </ul>
				</div>

				<div class="tip">
					<div class="tiptop">
						<span>提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="<%=basePath%>resource/theme/images/ticon.png" /> </span>
						<div class="tipright">
							<p>是否确认对信息的删除 ？</p>
							<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
						</div>
					</div>
					<div class="tipbtn">
						<input type="hidden" class="sure_value" value=""/>
						<input name="" type="button" class="sure" value="确定"/>
						&nbsp;
						<input name="" type="button" class="cancel" value="取消" />
					</div>
				</div>
			</div>
			</form>
			<script type="text/javascript">
				$('.tablelist tbody tr:odd').addClass('odd');
			</script>
	</body>
</html>
