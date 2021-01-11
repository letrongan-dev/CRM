<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-3">Danh sách thành viên</h3>
	<div class="row">
		<div class="col-md-8">
			<a href='<c:url value="/user/add"/>' class="btn btn-primary btn-lg">Thêm mới</a>
		</div>
		<div class="col-md-4">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Tìm kiếm...">
				<div class="input-group-append">
					<span class="input-group-text" id="basic-addon2"><i
						class="fa fa-search"></i></span>
				</div>
			</div>
		</div>
	</div>
	<table class="table table-bordered table-hover mt-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Start-Date</th>
				<th>End-Date</th>
				<th>User</th>
				<th>Status</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listTask }" var="task">
			<tr>
				<td>${task.id }</td>
				<td>${task.short_description }</td>
				<td>${task.start_date }</td>
				<td>${task.end_date }</td>
				<td>${task.status }</td>
				<td>${task.user_id }</td>
				<td><a href='<c:url value="/task/edit?id=${user.id }"/>' class="btn btn-sm btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a> <a href='<c:url value="/task/delete?id=${user.id }"/>' class="btn btn-sm btn-danger"> <i
						class="fa fa-trash-o"></i>
				</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</section>