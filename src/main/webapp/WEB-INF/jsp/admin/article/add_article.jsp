<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>add_article</title>
<meta charset="utf-8">
	<!-- bootstrap移动设备优先 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${pageContext.request.contextPath}/jslib/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
 	<link href="${pageContext.request.contextPath}/cssstyle/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/cssstyle/animate.css" rel="stylesheet" type="text/css">
	<!-- pace -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/jquery-plugins/pace/pace-theme-barber-shop.css" />
	<!-- 提示框 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/flavr/flavr/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/flavr/flavr/css/flavr.css" />
	<link href="${pageContext.request.contextPath}/cssstyle/style.css" rel="stylesheet" type="text/css">
<style>
.input-upload {
	position: relative;
}

.input-upload input[type="file"] {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 72px;
	height: 35px;
	opacity: .0;
	filter: alpha(opacity = 00);
}
</style>

</head>

<body>
	<div id="wrapper">
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-10">
					<h2>文章列表</h2>
					<ol class="breadcrumb">
						<li><a href="admin/home">主页</a></li>
						<li><a>文章管理</a></li>
						<li><a href="/admin/article/list">文章列表</a></li>
						<li><strong>新增文章</strong></li>
					</ol>
				</div>
				<div class="col-lg-2"></div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRight">

				<div class="row">
					<div class="col-lg-12">
						<div class="ibox float-e-margins">
							<div class="ibox-content">
								<form method="get" class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-2 control-label">栏目:</label>
										<div class="col-sm-4">
											<select class="form-control m-b" id="categoryId">
												<option value="-1">请选择</option>
												<c:forEach items="${categoryList}" var="category">
													<option value="${category.id}">${category.categoryName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">标题:</label>
										<div class="col-sm-10">
											<input type="text" id="title" class="form-control"
												placeholder="请输入标题">
										</div>
									</div>
									<div class="hr-line-dashed"></div>
									<div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-10">
											<script id="editor" type="text/plain"></script>
										</div>
									</div>
									<div class="hr-line-dashed"></div>

									<div class="form-group">
										<label class="col-sm-2 control-label">标签:</label>
										<div class="col-sm-10">
											<select data-placeholder="请选择标签" class="chosen-select"
												multiple style="width:450px;" tabindex="5">
												<c:forEach items="${tagList}" var="tag">
													<option value="${tag.id}" hassubinfo="true">${tag.tagName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4 col-sm-offset-2">
											<button class="btn btn-primary" type="button"
												onclick="saveArticle()">保存内容</button>
											<button class="btn btn-white" type="button"
												onclick="cancelSaveArticle()">取消</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>


	<!-- Mainly scripts -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/jquery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/jquery-plugins/pace/pace.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/flavr/flavr/js/flavr.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/flavr/base.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/commonutil/hplus.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/commonutil/validation.js"></script>
	<!-- 配置文件 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/ueditor1_4_3/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/ueditor1_4_3/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/jslib/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/article/add_article.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			var ue = UE.getEditor('editor');
		});

		// 初始化多选框
		$(".chosen-select").chosen({
			max_selected_options : 5,
			no_results_text : "没有找到",
			allow_single_deselect : true
		});
	</script>

</body>

</html>
