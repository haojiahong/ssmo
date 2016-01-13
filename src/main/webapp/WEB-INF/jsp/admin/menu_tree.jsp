<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
.img-circle {
	width: 64px;
}

</style>

<nav class="navbar-default navbar-static-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="side-menu">
			<li class="nav-header">
				<div class="dropdown profile-element">
					<span> <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/img/admin.png" /> </span> 
					<a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)"> 
						<span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${manager.userName}</strong> </span> 
						<span class="text-muted text-xs block"> 超级管理员 <b class="caret"></b> </span> </span> 
					</a>
					<ul class="dropdown-menu animated fadeInRight m-t-xs">
						<li><a href="">修改头像</a></li>
						<li><a href="">个人资料</a></li>
						<li><a href="">联系我们</a></li>
						<li><a href="">信箱</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/out">安全退出</a></li>
					</ul>
				</div>
				<div class="logo-element">H+</div>
				
			</li>

			<li class="active"><a href="javascript:void(0)"><i class="fa fa fa-volume-up"></i> <span class="nav-label">文章管理</span>
					<span class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li class="active"><a href="${pageContext.request.contextPath}/admin/article/list">文章列表</a>
					</li>
				</ul>
			</li>
			<li><a href="javascript:void(0)"><i class="fa fa fa-qrcode"></i> <span class="nav-label">标签管理</span> <span
					class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/admin/tag/list">标签列表</a>
					</li>
				</ul>
			</li>
			<li><a href="javascript:void(0)"><i class="fa fa fa-qrcode"></i> <span class="nav-label">合作伙伴管理</span> <span
					class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/admin/friend/list">合作伙伴列表</a>
					</li>
				</ul>
			</li>
		</ul>

	</div>
</nav>