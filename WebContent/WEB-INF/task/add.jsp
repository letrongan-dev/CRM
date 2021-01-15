<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Thêm mới công việc</h3>
	<form method="post" action='<c:url value="/task/add"/>'>
		<div class="row col-md-6 offset-md-3">
			<div class="col-md-12">
				<div class="form-group">
					<label>Tiêu đề</label> <input type="text" name="shortDesc"
						class="form-control" placeholder="short description" required/>
				</div>
				<div class="form-group">
					<label>Ngày bắt đầu</label> <input type="date" name="startDate"
						class="form-control" required/>
				</div>
				<div class="form-group">
					<label>Ngày kết thúc</label> <input type="date" name="endDate"
						class="form-control" required/>
				</div>
				<div class="form-group">
					<div><label>Mô tả</label></div>
					<textarea class="col-lg-12" name="desc"></textarea>
				</div>
				<div class="form-group">
                   <label for="status" class=" form-control-label">Công việc</label>
                      <select name="taskId" id="select" class="form-control">
                          <option value="0">None</option>
                          <c:forEach items="${listTask }" var="task">
                          <option value="${task.id }">${task.short_description }</option>
                          </c:forEach>
                      </select>
                </div>
			</div>
			<div class="col-md-6 offset-md-3">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/task" />'>Quay lại</a>
			</div>
		</div>
	</form>
</section>