<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>后台  - 登录</title>
    <jsp:include page="../syscommon/admin_inc.jsp"></jsp:include>
    
	<style>
	.loginscreen.middle-box{padding-top:260px;}
	</style>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name"></h1>
            </div>

            <form id="form" class="m-t" role="form" action="/admin/login">
                <div class="form-group">
                    <input type="text" name="userName" id="loginId" class="form-control" placeholder="用户名">
                </div>
                <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="密码">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="login()">登 录</button>

            </form>
        </div>
    </div>

<script type="text/javascript">
	toastr.options = {
				  "closeButton": true,
				  "debug": false,
				  "progressBar": true,
				  "positionClass": "toast-top-center",
				  "onclick": null,
				  "showDuration": "50",
				  "hideDuration": "100",
				  "timeOut": "1200",
				  "extendedTimeOut": "100",
				  "showEasing": "swing",
				  "hideEasing": "linear",
				  "showMethod": "fadeIn",
				  "hideMethod": "fadeOut"
	};
	
	// 登录
	function login(){
		var loginId = $("#loginId").val();
		var password = $("#password").val();
		if(isEmpty(loginId)){
			toastr.error("账户不能为空");
			//autoCloseAlert("账户不能为空",1000);
			return false;
		}
		
		if(isEmpty(password)){
			toastr.error("密码不能为空");
			//autoCloseAlert("密码不能为空",1000);
			return false;
		}
		$.ajax({
			url : "admin/login",
			data: $("#form").serialize(),
			method : "post",
			dataType : "json",
			success : function( data) {
				if (data.resultCode == 'success') {
					window.location.href = "admin/home";
				}else{
					toastr.error(data.info);
					//autoCloseAlert(data.errorInfo,1000);
					return false;
				}
			}
		});
	}
</script>
</body>

</html>
