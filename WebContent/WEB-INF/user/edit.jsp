<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Thêm mới thành viên</h3>
	<form method="post" action='<c:url value="/user/edit"/>' method="post">
		<div class="row col-md-6 offset-md-3">
			<input type="hidden" value="${userEdit.id }" name="id">
			<div class="col-md-12">
				<div class="form-group">
					<label>Họ tên</label> <input type="text" name="name"
						class="form-control" value="${userEdit.name }"/>
				</div>
				<div class="form-group">
					<label>Email</label> <input type="email" name="email"
						class="form-control" value="${userEdit.email }"required />
				</div>
				<div class="form-group">
                   <label for="select" class=" form-control-label">Role</label>
                      <select name="role" id="select" class="form-control">
                      <c:choose>
                      		<c:when test="${userEdit.role == 'ADMIN'}">
                      			<option value="ADMIN" selected>ADMIN</option>
							</c:when>
                      		<c:when test="${userEdit.role  == 'LEADER'}">
                      			<option value="ADMIN" selected>LEADER</option>
                      		</c:when>
                      		<c:when test="${userEdit.role == 'EMPLOYEE'}">
                      			<option value="ADMIN" selected>EMPLOYEE</option>
                      		</c:when>
                      		<c:otherwise>---Please select---</c:otherwise>
                      </c:choose>
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