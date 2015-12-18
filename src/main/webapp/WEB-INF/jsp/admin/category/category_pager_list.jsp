<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<table class="table table-striped table-bordered table-hover dataTables-example">
	<thead>
		<tr>
			<th>Id</th>
			<th>栏目名称</th>
			<th>栏目别名</th>
			<th>栏目图标</th>
			<th>栏目序号</th>
			<th>操作</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${categoryList}" var="category">
			<tr class="gradeX">
				<td>${category.id}</td>
				<td>${category.categoryName}</td>
				<td>${category.aliasName}</td>
				<td>${category.iconClass}</td>
				<td>${category.sortNum}</td>
				<td>
					<button class="btn btn-primary btn-xs" type="button" title="编辑" onclick="editCategory(${category.id})">编辑</button>
					<button class="btn btn-danger btn-xs" type="button" title="删除" onclick="deleteCategory(${category.id})">删除</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../../sys/pager.jsp" flush="true"></jsp:include>