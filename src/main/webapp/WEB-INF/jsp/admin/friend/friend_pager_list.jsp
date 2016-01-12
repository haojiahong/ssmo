<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<table class="table table-striped table-bordered table-hover dataTables-example">
	<thead>
		<tr>
			<th>Id</th>
			<th>名称</th>
			<th>站点地址</th>
			<th>描述</th>
			<th>排序</th>
			<th>操作</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${friendList}" var="friend">
			<tr class="gradeX">
				<td>${friend.id}</td>
				<td>${friend.friendName}</td>
				<td>${friend.friendUrl}</td>
				<td>${friend.friendDesc}</td>
				<td>${friend.sortNum}</td>
				<td>
					<button class="btn btn-primary btn-xs" type="button" title="编辑" onclick="editFriend(${friend.id})">编辑</button>
					<button class="btn btn-danger btn-xs" type="button" title="删除" onclick="deleteFriend(${friend.id})">删除</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../../syscommon/pager.jsp" flush="true"></jsp:include>