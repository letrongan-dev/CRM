<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<head>
	<title>Thêm mới quyền</title>
</head>	

<section id="admin-content" class="p-3">
	<h3 class="mb-4 text-center">Thêm mới quyền</h3>
	<form method="post" action="">
		<div class="row">
			<div class="col-md-6 m-auto">
				<div class="form-group">
					<label>Tên quyền</label> <input type="text" name="email"
						class="form-control" placeholder="name" />
				</div>
				<div class="form-group">
					<label>Mô tả</label> <input type="text" name="fullname"
						class="form-control" placeholder="description" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Lưu lại</button>
					<a class="btn btn-secondary" href="role-list.html">Quay lại</a>
				</div>
			</div>
		</div>
	</form>
</section>