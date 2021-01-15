<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Thêm mới thành viên</h3>
	<form method="post" action='<c:url value="/user/add"/>'>
		<div class="row col-md-6 offset-md-3">
			<div class="col-md-12">
				<div class="form-group">
					<label>Họ tên</label> <input type="text" name="name"
						class="form-control" placeholder="Họ và tên" required/>
				</div>
				<div class="form-group">
					<label>Email</label> <input type="email" name="email"
						class="form-control" placeholder="email" required/>
				</div>
				<div class="form-group">
					<label>Mật khẩu</label> <input type="password" name="password"
						class="form-control" placeholder="password" required/>
				</div>
				<div class="form-group">
                   <label for="select" class=" form-control-label">Quyền hệ thống</label>
                      <select name="role" id="select" class="form-control">
                          <option value="#">---Please select---</option>
                          <option value="ADMIN">ADMIN</option>
                          <option value="LEADER">LEADER</option>
                          <option value="EMPLOYEE">EMPLOYEE</option>
                      </select>
                </div>
			</div>
			<div class="col-md-6 offset-md-3">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/user" />'>Quay lại</a>
			</div>
		</div>
	</form>
</section>