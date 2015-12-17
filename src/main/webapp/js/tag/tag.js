$(function() {
	// 加载管理员列表
	loadTagList();
})

// 跳转分页
function toPage(page) {
	$("#page").val(page);
	loadTagList();
}

// 加载列表
function loadTagList() {
	// 收集参数
	var param = buildParam();

	var page = $("#page").val();
	if (isEmpty(page) || page == 0) {
		page = 1;
	}

	// 查询列表
	$.ajax({
		url : getRootPath() + '/admin/tag/load',
		data : 'page=' + page + "&param=" + param,
		success : function(data) {
			$("#dataList").html(data);
		}
	});

}

// 收集参数
function buildParam() {
	var param = {};
	var keyword = $("#keyword").val();
	if (!isEmpty(keyword)) {
		param["tagName"] = encodeURI(encodeURI(keyword));
	}
	return JSON.stringify(param);
}

// 搜索
function search() {
	loadTagList();
}

// 删除
function deleteTag(id) {
	$.ajax({
		url : getRootPath() + 'admin/tag/delete',
		data : 'id=' + id,
		success : function(data) {
			if (data.resultCode == 'success') {
				autoCloseAlert(data.errorInfo, 1000);
				loadTagList();
			} else {
				autoCloseAlert(data.errorInfo, 1000);
			}
		}
	});
}

// 跳转编辑页
function editTag(id) {
	$.ajax({
		url : getRootPath() + 'admin/tag/editJump/' + id,
		success : function(data) {
			$('#editTagContent').html(data);
			$('#editTagModal').modal('show');
			$('#editTagModal').addClass('animated');
			$('#editTagModal').addClass('flipInY');
		}
	});
}

// 关闭编辑窗口
function closeEditWindow() {
	$('#editTagModal').modal('hide');
}

// 关闭新增窗口
function closeAddWindow() {
	$('#addTagModal').modal('hide');
}

// 保存编辑
function saveEditTag() {
	if (validateTag()) {
		$.ajax({
			url : getRootPath() + 'admin/tag/edit',
			data : encodeURI($("#editForm").serialize()),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#editTagModal').modal('hide');
					loadTagList();
					autoCloseAlert(data.errorInfo, 1000);
				} else {
					autoCloseAlert(data.errorInfo, 1000);
				}
			}
		});
	}
}

// 保存新增
function saveAddTag() {
	if (validateTag()) {
		$.ajax({
			url : getRootPath() + 'admin/tag/add',
			data : encodeURI($("#addForm").serialize()),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#addTagModal').modal('hide');
					loadTagList();
					autoCloseAlert(data.errorInfo, 1000);
				} else {
					autoCloseAlert(data.errorInfo, 1000);
				}
			}
		});
	}
}

// 校验
function validateTag() {
	var tagName = $("#tagName").val();
	if (!isEmpty(tagName)) {
		if (isSpecialSymbols(tagName)) {
			autoCloseAlert("标签不能包含特殊符号", 1000);
			return false;
		}
	} else {
		autoCloseAlert("标签不能为空", 1000);
		return false;
	}

	return true;
}

// 跳转新增页面
function addTag() {
	$.ajax({
		url : getRootPath() + 'admin/tag/addJump',
		success : function(data) {
			$('#addTagContent').html(data);
			$('#addTagModal').modal('show');
			$('#addTagModal').addClass('animated');
			$('#addTagModal').addClass('bounceInLeft');
		}
	});
}