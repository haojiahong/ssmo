<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Tag</title>
	<meta charset="utf-8">
	<!-- bootstrap移动设备优先 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${pageContext.request.contextPath}/jslib/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="${pageContext.request.contextPath}/cssstyle/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" >
	<link href="${pageContext.request.contextPath}/cssstyle/animate.css" rel="stylesheet" type="text/css" >
	  <link href="${pageContext.request.contextPath}/cssstyle/style.css" rel="stylesheet" type="text/css" >
	
</head>
<body>
<div id="wrapper">
  
<div id="page-wrapper"  class="gray-bg dashbard-1">
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
	    <h2>标签列表</h2>
	    <ol class="breadcrumb">
	        <li>
	            <a href="/admin/home">主页</a>
	        </li>
	        <li>
	            <a>标签管理</a>
	        </li>
	        <li>
	            <strong>标签列表</strong>
	        </li>
	    </ol>
	</div>
    <div class="col-lg-2">

    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">
<div class="row">
<div class="col-lg-12">
<div class="ibox float-e-margins">
<div class="ibox-content">
<div class="row">
	<form class="form-inline">
	    <div class="col-sm-3">
		    <div class="input-group">
			    <input type="text" id="keyword" placeholder="请输入标签名称" class="input-sm form-control">
			    <span class="input-group-btn">
			    	<button type="button" class="btn btn-sm btn-primary" onclick="search()">搜索</button>
			    </span>
		    </div>
	     </div>
	     
	     <button type="button" class="btn btn-sm btn-danger" onclick="addTag()">新增标签</button>
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
            
<jsp:include page="../../sys/footer.jsp" flush="true"></jsp:include>

</div>
</div>
</body>
</html>
