<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src='<c:url value="/static/js/jquery.slim.min.js" />'></script>
<script src='<c:url value="/static/js/popper.min.js" />'></script>
<script src='<c:url value="/static/js/bootstrap.min.js" />'></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src='<c:url value="/static/js/function.js" />'></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<!-- <script>
$(document).ready(function() {
	$("#userVal").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					lettersonly : true,
					remote : {
						url: '<c:url value= "/available-name"/>',
						type: "get",
						data: {
							name: function() {
								return $("#name").val()+"131351651651";
							}
						}
					}
				},
				email: {
					required : true,
					email: true,
					remote : {
						url: '<c:url value= "/available"/>',
						type: "get",
						data: {
							email: function() {
								return $("#email").val();
							}
						}
					}
				},
				password: {
					required : true,
					minlength : 5
				},
			},
			messages: {
				email: {
					remote: "Email already exists!"
				},
				name: {
					remote: "Name already exists!"
				}
			
			}
		}
	);
});
</script> -->