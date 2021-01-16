<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section id="admin-content" class="p-3">
	<h3 class="mb-3">Danh sách công việc ${taskGet.short_description }</h3>
	<div class="row">
		<div class="col-md-8">
			 <a class="btn btn-info text-white" data-toggle="modal" data-target="#addModal">
                <i class="fa fa-pencil-square-o">THÊM MỚI</i>
            </a>
		</div>
		<div class="col-md-4">
			<form action='<c:url value="/task/search"/>' method="get">
			<div class="input-group">
				<input type="text" class="form-control" name="key" placeholder="Tìm kiếm...">
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
				<td>${task.id }</td>
				<td><a href='<c:url value="/task/get-task?id=${task.id }"/>'>
				${task.short_description }</a></td>
				<td><fmt:formatDate value="${task.start_date }" type="date" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatDate value="${task.end_date }" type="date" pattern="dd/MM/yyyy"/></td>
				<td>
				<c:forEach items="${listUser }" var="user">
					<c:if test="${user.id == task.user_id }">
							${user.name }
					</c:if>
				</c:forEach>
				</td>
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
                   			<td>Đang hoàn thành</td>
                   		</c:when>
                   		<c:otherwise>No Valid</c:otherwise>
                 </c:choose>
                 
				<td><a href='<c:url value="/task/edit?id=${task.id }"/>' class="btn btn-info"> <i
						class="fa fa-pencil-square-o"></i>
				</a><a data-confirm='Bạn thật sự muốn xóa công việc này ?' 
					href='<c:url value="/task/delete?id=${task.id }"/>' class="btn btn-danger"><i class="fa fa-trash-o"></i>
				</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="col-md-6 offset-md-3 text-center">
		 <button type="button" class="btn btn-secondary" onclick="quay_lai_trang_truoc()">Quay lại</button>
	</div>
 <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
   <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">Thêm task vào ${taskGet.short_description}</h4>
       </div>
       <div class="modal-body">
        <form action='<c:url value="/task/insert"/>' method="post">
        	 <input type="hidden" name="taskId" value="${taskGet.id }">
          <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Title</label>
            <input class="form-control" name="shortDesc" required>
          </fieldset>
          </div>
          <div class="col-lg-12">
          <fieldset class="form-group">
			<label>Ngày bắt đầu</label> 
			<input type="text" name="startDate" id="start" readonly="readonly" class="form-control"/>
          </fieldset>
        </div>
        <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Ngày kết thúc</label> 
            <input type="text" name="endDate" id="end" readonly="readonly" class="form-control"/>
          </fieldset>
        </div>
        <div class="col-lg-12">
	        <div class="form-group">
				<div><label>Mô tả</label></div>
				<textarea class="col-lg-12" name="desc"></textarea>
			 </div>
		 </div>
        <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Người thực hiện</label> 
            <select class="form-control" name="userId">
            	<c:forEach items="${listUser }" var="user">
               <option value="${user.id }">${user.name }</option>    
            	</c:forEach>    
              </select>
          </fieldset>
        </div>
       </div>
       <div class="modal-footer">
         <button type="submit" class="btn btn-primary">SAVE</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
       </form>
     </div>
   </div>
 </div>
<%--<c:forEach items="${listTask }" var="taskEditModal">
<div class="modal fade" id="editModal${taskEditModal.id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
   <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">Cập nhật dự án</h4>
       </div>
       <div class="modal-body">
        <form action='<c:url value="/task/edit"/>' method="post">
        	 <input type="hidden" name="id" value="${taskEditModal.id }">
          <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Title</label>
            <input class="form-control" name="shortDesc" value="${taskEditModal.short_description }"  required>
          </fieldset>
          </div>
          <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Ngày bắt đầu</label>
            <input class="form-control" type="date" name="startDate" value="${taskEditModal.start_date }">
          </fieldset>
        </div>
        <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Ngày kết thúc</label>
            <input class="form-control" type="date" name="endDate" value="${taskEditModal.end_date }">
          </fieldset>
        </div>
        <div class="form-group">
		<div><label>Description</label></div>
		<textarea class="col-lg-12" name="desc">${taskEditModal.description }</textarea>
 		</div>
        <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Người thực hiện</label> 
            <select class="form-control" name="userId">
            	 <c:forEach items="${listUser }" var="user">
	            	<c:choose>
	            		<c:when test="${user.id == taskEditModal.user_id }">
	            		<option value="${user.id }" selected="selected">${user.name }</option>
	            		</c:when>
	            		<c:otherwise><option value="${user.id }">${user.name }</option></c:otherwise>    
	            	</c:choose>
	            	</c:forEach>        
              </select>
          </fieldset>
        </div>
       </div>
       <div class="modal-footer">
         <button type="submit" class="btn btn-primary">SAVE</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
       </form>
     </div>
   </div>
 </div>
</c:forEach> --%>
</section>
