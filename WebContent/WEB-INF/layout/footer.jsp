<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src='<c:url value="/static/js/jquery.slim.min.js" />'></script>
<script src='<c:url value="/static/js/popper.min.js" />'></script>
<script src='<c:url value="/static/js/bootstrap.min.js" />'></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$(document).ready(function(){
    $('[data-confirm]').on('click', function(e){
        e.preventDefault(); //cancel default action

        //Recuperate href value
        var href = $(this).attr('href');
        var message = $(this).data('confirm');

        //pop up
        swal({
            title: "Thông báo",
            text: message, 
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((willDelete) => {
          if (willDelete) {
            swal("Xóa thành công!!", {
              icon: "success",
              timmer:20000
            });
            window.location.href = href;
          }
        });
    });
    
});
</script>
