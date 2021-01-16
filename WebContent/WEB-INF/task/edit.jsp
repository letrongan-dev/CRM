<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Cập nhật công việc</h3>
	<form method="post" action='<c:url value="/task/edit"/>'>
		<div class="row col-md-6 offset-md-3">
			<div class="col-md-12">
				<input type="hidden" name="id"
						class="form-control" value="${taskEdit.id }"/>
				<div class="form-group">
					<label>Tiêu đề</label> <input type="text" name="shortDesc"
						class="form-control" value="${taskEdit.short_description }"/>
				</div>
				<div class="form-group">
					<label>Ngày bắt đầu</label> <input type="text" name="startDate" id="start" readonly="readonly"
						class="form-control" value="${taskEdit.start_date }"/>
				</div>
				<div class="form-group">
					<label>Ngày kết thúc</label> <input type="text" name="endDate" id="end" readonly="readonly"
						class="form-control" value="${taskEdit.end_date }"/>
				</div>
				<div class="form-group">
					<div><label>Mô tả</label></div>
					<textarea class="col-lg-12" name="desc">${taskEdit.description }</textarea>
				</div>
				<div class="form-group">
		            <label>Người thực hiện</label> 
		            <select class="form-control" name="userId">
		            	 <option value="0">---Please select---</option>
		            	<c:forEach items="${listUser }" var="user">
		            	<c:choose>
		            		<c:when test="${user.id == taskEdit.user_id }">
		            		<option value="${user.id }" selected="selected">${user.name }</option>
		            		</c:when>
		            	<c:otherwise><option value="${user.id }">${user.name }</option></c:otherwise>
		            	</c:choose>    
		            	</c:forEach>    
		              </select>
		        </div>
				<!-- <div class="col-lg-12">
	            <fieldset class="form-group">
	              <label>Task</label> 
	              <select class="form-control" name="taskId">
	              	 <option value="0">---Please select---</option>
	              	<c:forEach items="${listTask }" var="task">
	              		<c:choose>
	              			<c:when test="${taskEdit.task_id == task.id}">
	              				<option value="${task.id }" selected="selected">${task.short_description }</option>
	              			</c:when>
	              			<c:otherwise><option value="${task.id }">${task.short_description }</option></c:otherwise>
	              		</c:choose>
	              	</c:forEach>    
	                </select>
	            </fieldset>
	          </div>
			</div> -->
			<div class="col-md-6 offset-md-3">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/task" />'>Quay lại</a>
			</div>
		</div>
	</form>
</section>