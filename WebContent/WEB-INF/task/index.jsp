<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section id="admin-content" class="p-3">
	<h3 class="mb-3">Danh sách công việc</h3>
	<div class="row">
		<div class="col-md-8">
			<a href='<c:url value="/task/add"/>' class="btn btn-primary">Thêm mới</a>
		</div>
		<div class="col-md-4">
		 <form action='<c:url value="/task/search"/>' method="get">
			<div class="input-group">
				<input type="text" class="form-control" name="key" placeholder="Tìm kiếm..." value="${key }">
				<button type="submit" class="input-group-text" id="basic-addon2"><i
				class="fa fa-search"></i></button>	
			</div>
		</form> 
		</div>
	</div>
	<table class="table table-bordered table-hover mt-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Tiêu đề</th>
				<th>Ngày bắt đầu</th>
				<th>Ngày kết thúc</th>
				<th>Người thực hiện</th>
				<th>Trạng thái</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listTask }" var="task">
			<tr>
				<%-- <td>
                  <button type="button" class="btn btn-success btn-sm fa fa-info text-black" data-toggle="modal" data-target="#mediumModal${task.id}"></button>
                </td> --%>
				<td>${task.id }</td>
				<td>
				<a href='<c:url value="/task/get-task?id=${task.id }"/>'>
				${task.short_description }</a></td>
				<td><fmt:formatDate value="${task.start_date }" type="date" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatDate value="${task.end_date }" type="date" pattern="dd/MM/yyyy"/></td>
				<td>${task.nameUser }</td>
				<c:choose>
					<c:when test="${task.status == '0'}">
               			<td>*</td>
					</c:when>
               		<c:when test="${task.status == '1'}">
               			<td>Đang thực hiện</td>
					</c:when>
               		<c:when test="${task.status == '2'}">
               			<td>Đang test</td>
               		</c:when>
               		<c:when test="${task.status == '3'}">
               			<td>Đã hoàn thành</td>
               		</c:when>
               		<c:otherwise>No Valid</c:otherwise>
                 </c:choose>
                 
				<td><!--  <a href='<c:url value="/task/get-task?id=${task.id }"/>' class="btn btn-warning">
						<i class="fa fa-info-circle"></i>
				</a>--><a href='<c:url value="/task/edit?id=${task.id }"/>' class="btn btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a><a data-confirm='Bạn thật sự muốn xóa công việc này ?' 
					href='<c:url value="/task/delete?id=${task.id }"/>' class="btn btn-danger"><i class="fa fa-trash-o">
					</i></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<%-- <c:forEach items="${listTask}" var="task">
<div class="modal fade" id="mediumModal${task.id }" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">Mô tả công việc</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                    ${task.description }
                </p>
            </div>
        </div>
    </div>
</div>
</c:forEach> --%>
 
 