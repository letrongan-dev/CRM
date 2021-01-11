<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Thêm mới công việc</h3>
	<form method="post" action='<c:url value="/user/add"/>'>
		<div class="row col-md-6 offset-md-3">
			<div class="col-md-12">
				<div class="form-group">
					<label>Title</label> <input type="text" name="title"
						class="form-control" placeholder="short description" required/>
				</div>
				<div class="form-group">
					<label>Start Date</label> <input type="date" name="startDate"
						class="form-control" required/>
				</div>
				<div class="form-group">
					<label>End Date</label> <input type="date" name="endDate"
						class="form-control" required/>
				</div>
				
				<div class="form-group">
                   <label for="status" class=" form-control-label">Status</label>
                      <select name="role" id="select" class="form-control">
                          <option value="#">---Please select---</option>
                          <option value="1">Đang thực hiện</option>
                          <option value="2">Đang test</option>
                          <option value="3">Đã hoàn thành</option>
                      </select>
                </div>
			</div>
			<div class="col-md-6 offset-md-3">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href="user-list.html">Quay lại</a>
			</div>
		</div>
	</form>
</section>