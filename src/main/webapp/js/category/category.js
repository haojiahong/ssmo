$(function() {
	// 加载管理员列表
	loadCategoryList();
})

// 跳转分页
function toPage(page) {
	$("#page").val(page);
	loadCategoryList();
}

// 加载列表
function loadCategoryList() {
	// 收集参数
	var param = buildParam();

	var page = $("#page").val();
	if (isEmpty(page) || page == 0) {
		page = 1;
	}

	// 查询列表
	$.ajax({
		url : getRootPath() + 'admin/category/load',
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
		param["categoryName"] = encodeURI(encodeURI(keyword));
	}
	return JSON.stringify(param);
}

// 搜索
function search() {
	loadCategoryList();
}

// 删除
function deleteCategory(id) {
	$.ajax({
		url : getRootPath() + 'admin/category/delete/' + id,
		success : function(data) {
			if (data.resultCode == 'success') {
				autoCloseAlert(data.info, 1000);
				loadCategoryList();
			} else {
				autoCloseAlert(data.info, 1000);
			}
		}
	});
}

// 跳转编辑页
function editCategory(id) {
	$.ajax({
		url : getRootPath() + 'admin/category/editJump/' + id,
		success : function(data) {
			$('#editCategoryContent').html(data);
			$('#editCategoryModal').modal('show');
			$('#editCategoryModal').addClass('animated');
			$('#editCategoryModal').addClass('flipInY');
		}
	});
}

// 关闭编辑窗口
function closeEditWindow() {
	$('#editCategoryModal').modal('hide');
}

// 关闭新增窗口
function closeAddWindow() {
	$('#addCategoryModal').modal('hide');
}

// 保存编辑
function saveEditCategory() {
	if (validateCategory()) {
		$.ajax({
			url : getRootPath() + 'admin/category/edit',
			type : 'post',
			data : $("#editForm").serialize(),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#editCategoryModal').modal('hide');
					loadCategoryList();
					autoCloseAlert(data.info, 1000);
				} else {
					autoCloseAlert(data.info, 1000);
				}
			}
		});
	}
}

// 保存新增
function saveAddCategory() {
	if (validateCategory()) {
		$.ajax({
			url : getRootPath() + 'admin/category/add',
			type : 'post',
			data : $("#addForm").serialize(),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#addCategoryModal').modal('hide');
					loadCategoryList();
					autoCloseAlert(data.info, 1000);
				} else {
					autoCloseAlert(data.info, 1000);
				}
			}
		});
	}
}

// 校验
function validateCategory() {
	var categoryName = $("#categoryName").val();
	if (!isEmpty(categoryName)) {
		if (isSpecialSymbols(categoryName)) {
			autoCloseAlert("栏目不能包含特殊符号", 1000);
			return false;
		}
	} else {
		autoCloseAlert("栏目不能为空", 1000);
		return false;
	}

	return true;
}

// 跳转新增页面
function addCategory() {
	$.ajax({
		url : getRootPath() + 'admin/category/addJump',
		success : function(data) {
			$('#addCategoryContent').html(data);
			$('#addCategoryModal').modal('show');
			$('#addCategoryModal').addClass('animated');
			$('#addCategoryModal').addClass('bounceInLeft');
		}
	});
}