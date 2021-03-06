<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>article</title>
	<jsp:include page="../../syscommon/admin_inc.jsp"></jsp:include>
	<style>
		.btn-circle {
		  width: 20px;
		  height: 20px;
		  border-radius: 10px;
		}
		.fa{
		
		  position: relative;
		  top: -3px;
		}
	</style>
	
</head>
<body>
<div id="wrapper">

<jsp:include page="../menu_tree.jsp" flush="true"></jsp:include>

<div id="page-wrapper"  class="gray-bg dashbard-1">
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-md-10">
	    <h2>文章列表</h2>
	    <ol class="breadcrumb">
	        <li>
	            <a href="/admin/home">主页</a>
	        </li>
	        <li>
	            <a>文章管理</a>
	        </li>
	        <li>
	            <strong>文章列表</strong>
	        </li>
	    </ol>
	</div>
    <div class="col-md-2">

    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">
<div class="row">
<div class="col-md-12">
<div class="ibox float-e-margins">
<div class="ibox-content">
<div class="row">
	<div class="col-sm-3 m-b-xs">
		<select id="categoryId" name="categoryId" class="input-sm form-control input-s-sm inline" style="font-size: 12px;">
			<option value="-1">请选择栏目</option>
			<c:forEach items="${categoryList}" var="category">
				<option value="${category.id}">${category.categoryName}</option>
             </c:forEach>
        </select>
   	</div>
   	<div class="col-sm-3 m-b-xs">
		<select id="tagId" name="tagId" class="input-sm form-control input-s-sm inline" style="font-size: 12px;">
			<option value="-1">请选择标签</option>
			<c:forEach items="${tagList}" var="tag">
				<option value="${tag.id}">${tag.tagName}</option>
        	</c:forEach>
    	</select>
	</div>
	<div class="col-sm-3">
		<div class="input-group">
			<input type="text" id="keyword" placeholder="请输入标题" class="input-sm form-control" style="font-size: 12px;">
			<span class="input-group-btn">
				<button type="button" class="btn btn-sm btn-primary" onclick="search()">搜索</button>
			</span>
     	</div>
	</div>

	<button type="button" class="btn btn-sm btn-danger" onclick="addArticle()">新增文章</button>
	<button type="button" id="htmlAll" class="btn btn-sm btn-info" onclick="htmlAllArticle()">全局静态化</button>
</div>
       
<!-- 表格数据 -->
<div id="dataList">
                         
</div>
</div>
</div>
</div>
</div>
</div>
            
<jsp:include page="../../syscommon/footer.jsp" flush="true"></jsp:include>

</div>
</div>

<!-- 编辑页面 -->
<div class="modal inmodal" id="editArticleModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog">
	<div id="editArticleContent" class="modal-body">
          
	</div>                  
</div>											                                    
</div>
    
    
<!-- 新增页面 -->
<div class="modal inmodal" id="addArticleModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog">
	<div id="addArticleContent" class="modal-body">
	
	</div>                  
</div>												                                    
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/article/article.js"></script>

</body>
</html>
