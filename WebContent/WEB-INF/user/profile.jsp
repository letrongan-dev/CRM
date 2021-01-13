<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section id="admin-content" class="p-3">
	<h3 class="mb-3 text-center">Thông tin cá nhân</h3>
</section>
 <section class="services-section ftco-section">  
  <div class="content" >
      <div class="row">
        <div class="col-lg-12">
          <div class="info-box">
            <div class="card tab-style1"> 
              <!-- Nav tabs -->
              <ul class="nav nav-tabs profile-tab" role="tablist">
                <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#profile" role="tab" aria-expanded="true">Dashboard</a> </li>
                <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#settings" role="tab" aria-expanded="false">Settings</a> </li>
              </ul>
              <!-- Tab panes -->
              <div class="tab-content">
                <!--second tab-->
                <div class="tab-pane active" id="profile" role="tabpanel" aria-expanded="true">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-lg-3 col-xs-6 b-r"> <strong>Họ tên</strong> <br>
                        <p class="text-muted">${LOGIN.name }</p>
                      </div>
                      <div class="col-lg-3 col-xs-6 b-r"> <strong>Email</strong> <br>
                        <p class="text-muted">${LOGIN.email }</p>
                      </div>
                      <div class="col-lg-3 col-xs-6 b-r"> <strong>Chức vụ</strong> <br>
                        <p class="text-muted">${LOGIN.role }</p>
                      </div>
                    </div>
                    <div class="col-sm-12 mb-4">
                        <div class="card-group">
                            <div class="card col-md-6 no-padding ">
                                <div class="card-body">
                                    <div class="h1 text-muted text-right mb-4">
                                        <i class="fa fa-pie-chart"></i>
                                    </div>
                                    <div class="h4 mb-0">
                                        <span class="count">${countStatus1 }</span>
                                    </div>
                                    <small class="text-muted text-uppercase font-weight-bold">Đang thực hiện</small>
                                    <div class="progress progress-xs mt-3 mb-0 bg-flat-color-4" style="width: 40%; height: 5px;"></div>
                                </div>
                            </div>
                            <div class="card col-md-6 no-padding ">
                                <div class="card-body">
                                    <div class="h1 text-muted text-right mb-4">
                                        <i class="fa fa-clock-o"></i>
                                    </div>
                                    <div class="h4 mb-0">${countStatus2 }</div>
                                    <small class="text-muted text-uppercase font-weight-bold">Đang test</small>
                                    <div class="progress progress-xs mt-3 mb-0 bg-flat-color-5" style="width: 40%; height: 5px;"></div>
                                </div>
                            </div>
                            <div class="card col-md-6 no-padding ">
                                <div class="card-body">
                                    <div class="h1 text-muted text-right mb-4">
                                        <i class="fa fa-comments-o"></i>
                                    </div>
                                    <div class="h4 mb-0">
                                        <span class="count">${countStatus3 }</span>
                                    </div>
                                    <small class="text-muted text-uppercase font-weight-bold">Đã hoàn thành</small>
                                    <div class="progress progress-xs mt-3 mb-0 bg-flat-color-1" style="width: 40%; height: 5px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                  </div>
                  <div class="col-lg-12">
                  <div class="text-center pb-4">
		            <span class="font-weight-bold ">DANH SÁCH CÔNG VIỆC</span>
		           </div>
		            <div class="table-responsive">
		              <table class="table table-striped">
		                <thead>
		                  <tr>
		                    <th scope="col">Title</th>
		                    <th scope="col">Start date</th>
		                    <th scope="col">End date</th>
		                    <th scope="col">Description</th>
		                    <th scope="col">Status</th>
		                    <th scope="col">#</th>
		                  </tr>
		                </thead>
		                <tbody>
		                <c:forEach items="${listTaskUser }" var="taskUser">
		                  <tr>
		                    <th scope="row">${taskUser.short_description }</th>
							<td><fmt:formatDate value="${taskUser.start_date }" type="date" pattern="dd/MM/yyyy"/></td>
							<td><fmt:formatDate value="${taskUser.end_date }" type="date" pattern="dd/MM/yyyy"/></td>
		                    <td>${taskUser.description }</td>
		                    <td>
		                    <c:choose>
		                    	<c:when test="${taskUser.status == '1'}">Đang thực hiện</c:when>
		                    	<c:when test="${taskUser.status == '2'}">Đang test</c:when>
		                    	<c:when test="${taskUser.status == '3'}">Đã hoàn thành</c:when>
		                    	<c:otherwise>*</c:otherwise>
		                    </c:choose>
		                    	
		                    </td>
		                    <td><a class="btn btn-primary text-white" data-toggle="modal" data-target="#editModal${taskUser.id }">
                				<i class="fa fa-pencil-square-o"></i></a>
                			</td>
		                  </tr>
		                </c:forEach>
		                </tbody>
		              </table>
		            </div>
		          </div>
                </div>
                <div class="tab-pane" id="settings" role="tabpanel">
                  <div class="card-body">
                  <h3 class="text-center text-red">Đổi mật khẩu</h3>
                    <form action="" method="post">
                      <input type="hidden" name="code">
                      <div class="form-group">
                        <label class="col-md-6 offset-md-3">Mật khẩu cũ</label>
                        <div class="col-md-6 offset-md-3">
                          <input value="password" class="form-control form-control-line" type="password">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="col-md-6 offset-md-3">Mật khẩu mới</label>
                        <div class="col-md-6 offset-md-3">
                          <input value="password" class="form-control form-control-line" type="password">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label class="col-md-6 offset-md-3">Nhập lại mật khẩu mới</label>
                        <div class="col-md-6 offset-md-3">
                          <input value="password" class="form-control form-control-line" type="password" name="rePassword">
                        </div>
                      </div>
                     
                      <div class="form-group">
                        <div class="col-sm-12 text-center">
                          <button class="btn btn-success">Update Password</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Main row --> 
    </div>
    <!-- /.content --> 
<c:forEach items="${listTaskUser }" var="task">
<div class="modal fade" id="editModal${task.id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
   <div class="modal-dialog" role="document">
     <div class="modal-content">
       <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">Cập nhật dự án</h4>
       </div>
       <div class="modal-body">
        <form action='<c:url value="/update-status"/>' method="post">
        	 <input type="hidden" name="id" value="${task.id }">
          <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Title</label>
            <input class="form-control" name="shortDesc" value="${task.short_description }"  disabled>
          </fieldset>
          </div>
          <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Ngày bắt đầu</label>
            <input class="form-control" type="date" name="startDate" value="${task.start_date }" disabled>
          </fieldset>
        </div>
        <div class="col-lg-12">
          <fieldset class="form-group">
            <label>Ngày kết thúc</label>
            <input class="form-control" type="date" name="endDate" value="${task.end_date }" disabled>
          </fieldset>
        </div>
        <div class="form-group">
		<label>Description</label>
		<textarea class="col-lg-12" name="desc" disabled>${task.description }"</textarea>
 		</div>
        <div class="form-group">
          <label for="select" class=" form-control-label">Status</label>
             <select name="status" id="select" class="form-control">
                 <option value="0">---Please select---</option>
                 <option value="1">Đang thực hiện</option>
                 <option value="2">Đang test</option>
                 <option value="3">Đã hoàn thành</option>         
             </select>
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
</c:forEach>
 </section>