<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Category</title>
	<meta charset="utf-8">
	<!-- bootstrap移动设备优先 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${pageContext.request.contextPath}/jslib/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="${pageContext.request.contextPath}/cssstyle/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" >
	<link href="${pageContext.request.contextPath}/cssstyle/animate.css" rel="stylesheet" type="text/css" >
	<!-- pace -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/jquery-plugins/pace/pace-theme-barber-shop.css" />
	<!-- 提示框 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/flavr/flavr/css/animate.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jslib/flavr/flavr/css/flavr.css" />
	<link href="${pageContext.request.contextPath}/cssstyle/style.css" rel="stylesheet" type="text/css" >
	
</head>
<body>
<div id="wrapper">
  
<div id="page-wrapper"  class="gray-bg dashbard-1">
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-md-10">
	    <h2>栏目列表</h2>
	    <ol class="breadcrumb">
	        <li>
	            <a href="/admin/home">主页</a>
	        </li>
	        <li>
	            <a>栏目管理</a>
	        </li>
	        <li>
	            <strong>栏目列表</strong>
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
	<form class="form-inline">
	    <div class="col-sm-3">
		    <div class="input-group">
			    <input type="text" id="keyword" placeholder="请输入栏目名称" class="input-sm form-control">
			    <span class="input-group-btn">
			    	<button type="button" class="btn btn-sm btn-primary" onclick="search()">搜索</button>
			    </span>
		    </div>
	     </div>
	     <div class="col-sm-3">
		     <button type="button" class="btn btn-sm btn-danger" onclick="addCategory()">新增栏目</button>
	     </div>
	     
	     <div class="col-sm-6"></div>
     </form>
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
<div class="modal inmodal" id="editCategoryModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog">
	<div id="editCategoryContent" class="modal-body">
          
	</div>                  
</div>											                                    
</div>
    
    
<!-- 新增页面 -->
<div class="modal inmodal" id="addCategoryModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog">
	<div id="addCategoryContent" class="modal-body">
	
	</div>                  
</div>												                                    
</div>

<!-- Mainly scripts -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-plugins/pace/pace.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/flavr/flavr/js/flavr.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/flavr/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/commonutil/hplus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/commonutil/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/category/category.js"></script>

</body>
</html>
