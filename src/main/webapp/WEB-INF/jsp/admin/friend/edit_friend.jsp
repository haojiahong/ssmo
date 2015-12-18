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

<form id="editForm" method="post" class="form-horizontal">
	<fieldset>
		<legend>编辑合作伙伴</legend>
		<input type="hidden" name="id" id="id" value="${friend.id}">
		<div class="form-group">
			<label class="col-sm-2 control-label">名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="friendName" name="friendName" value="${friend.friendName }"
					maxlength="32">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="friendUrl" name="friendUrl" value="${friend.friendUrl }" maxlength="32">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">描述</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="friendDesc" name="friendDesc" value="${friend.friendDesc }"
					maxlength="32">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">排序</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sortNum" name="sortNum" value="${friend.sortNum }" maxlength="11">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<button class="btn btn-primary" type="button" onclick="saveEditFriend()">保存</button>
				<button class="btn btn-white" type="button" onclick="closeEditWindow()">取消</button>
			</div>
		</div>
	</fieldset>
</form>
