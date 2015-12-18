<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<style>
fieldset {
	border: 1px solid #1ab394;
	padding: 10px;
}

legend {
	display: block;
	width: auto;
	padding: 0;
	margin-bottom: 0;
	font-size: 14px;
	color: #333;
	border: none;
}
</style>
<form id="addForm" method="post" class="form-horizontal">
	<fieldset>
		<legend>编辑栏目</legend>
		<div class="form-group">
			<label class="col-sm-2 control-label">栏目</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="categoryName" name="categoryName" maxlength="20">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">别名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="aliasName" name="aliasName" maxlength="20">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">图标地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="iconClass" name="iconClass" maxlength="64">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">序号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sortNum" name="sortNum" maxlength="11">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<button class="btn btn-primary" type="button" onclick="saveAddCategory()">保存</button>
				<button class="btn btn-white" type="button" onclick="closeAddWindow()">取消</button>
			</div>
		</div>
	</fieldset>
</form>
