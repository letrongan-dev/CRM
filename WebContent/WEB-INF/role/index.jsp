<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="admin-content" class="p-3">
	<h3 class="mb-3">Danh sách quyền</h3>
	<div class="row">
		<div class="col-md-8">
			<a href="role-add.html" class="btn btn-primary">Thêm mới</a>
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
				<th>STT</th>
				<th>Tên Quyền</th>
				<th>Mô Tả</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>ROLE_ADMIN</td>
				<td>Quản trị hệ thống</td>
				<td><a href="role-edit.html" class="btn btn-sm btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a> <a href="#" class="btn btn-sm btn-danger"> <i
						class="fa fa-trash-o"></i>
				</a></td>
			</tr>
			<tr>
				<td>2</td>
				<td>ROLE_TEACHER</td>
				<td>Giảng viên</td>
				<td><a href="role-edit.html" class="btn btn-sm btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a> <a href="#" class="btn btn-sm btn-danger"> <i
						class="fa fa-trash-o"></i>
				</a></td>
			</tr>
			<tr>
				<td>3</td>
				<td>ROLE_STUDENT</td>
				<td>Học viên viên</td>
				<td><a href="role-edit.html" class="btn btn-sm btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a> <a href="#" class="btn btn-sm btn-danger"> <i
						class="fa fa-trash-o"></i>
				</a></td>
			</tr>
		</tbody>
	</table>
</section>