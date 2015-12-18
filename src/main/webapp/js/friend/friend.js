$(function() {
	// 加载管理员列表
	loadFriendList();
})

// 跳转分页
function toPage(page) {
	$("#page").val(page);
	loadFriendList();
}

// 加载列表
function loadFriendList() {
	// 收集参数
	var param = buildParam();

	var page = $("#page").val();
	if (isEmpty(page) || page == 0) {
		page = 1;
	}

	// 查询列表
	$.ajax({
		url : getRootPath() + 'admin/friend/load',
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
		param["friendName"] = encodeURI(encodeURI(keyword));
	}
	return JSON.stringify(param);
}

// 搜索
function search() {
	loadFriendList();
}

// 删除
function deleteFriend(id) {
	$.ajax({
		url : getRootPath() + 'admin/friend/delete/' + id,
		success : function(data) {
			if (data.resultCode == 'success') {
				autoCloseAlert(data.info, 1000);
				loadFriendList();
			} else {
				autoCloseAlert(data.info, 1000);
			}
		}
	});
}

// 跳转编辑页
function editFriend(id) {
	$.ajax({
		url : getRootPath() + 'admin/friend/editJump/' + id,
		success : function(data) {
			$('#editFriendContent').html(data);
			$('#editFriendModal').modal('show');
			$('#editFriendModal').addClass('animated');
			$('#editFriendModal').addClass('flipInY');
		}
	});
}

// 关闭编辑窗口
function closeEditWindow() {
	$('#editFriendModal').modal('hide');
}

// 关闭新增窗口
function closeAddWindow() {
	$('#addFriendModal').modal('hide');
}

// 保存编辑
function saveEditFriend() {
	if (validateFriend()) {
		$.ajax({
			url : getRootPath() + 'admin/friend/edit',
			type : 'post',
			data : $("#editForm").serialize(),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#editFriendModal').modal('hide');
					loadFriendList();
					autoCloseAlert(data.info, 1000);
				} else {
					autoCloseAlert(data.info, 1000);
				}
			}
		});
	}
}

// 保存新增
function saveAddFriend() {
	if (validateFriend()) {
		$.ajax({
			url : getRootPath() + 'admin/friend/add',
			type : 'post',
			data : $("#addForm").serialize(),
			success : function(data) {
				if (data.resultCode == 'success') {
					$('#addFriendModal').modal('hide');
					loadFriendList();
					autoCloseAlert(data.info, 1000);
				} else {
					autoCloseAlert(data.info, 1000);
				}
			}
		});
	}
}

// 校验
function validateFriend() {
	var friendName = $("#friendName").val();
	if (!isEmpty(friendName)) {
		if (isSpecialSymbols(friendName)) {
			autoCloseAlert("名称不能包含特殊符号", 1000);
			return false;
		}
	} else {
		autoCloseAlert("名称不能为空", 1000);
		return false;
	}

	return true;
}

// 跳转新增页面
function addFriend() {
	$.ajax({
		url : getRootPath() + 'admin/friend/addJump',
		success : function(data) {
			$('#addFriendContent').html(data);
			$('#addFriendModal').modal('show');
			$('#addFriendModal').addClass('animated');
			$('#addFriendModal').addClass('bounceInLeft');
		}
	});
}