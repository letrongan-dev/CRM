
//Return back
function quay_lai_trang_truoc(){
        history.back();
    }
//pop-up delete
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
//Jquery validation
jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-z\s]+$/i.test(value);
	}, "Only alphabetical characters");


$(document).ready(function() {
	var url = "http://localhost:8081/CRM_Servlet";
	
	$("#userVal").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					lettersonly : true,
					remote : {
						url: url+"/available-name",
						type: "get",
						data: {
							name: function() {
								return $("#name").val();
							}
						}
					}
				},
				email: {
					required : true,
					email: true,
					remote : {
						url: decodeURI(url+"/availabel"),
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
//validate task endDate
$(function(){
    $("#end").datepicker({ dateFormat: 'yy-mm-dd' });
    $("#start").datepicker({ dateFormat: 'yy-mm-dd' }).bind("change",function(){
        var minValue = $(this).val();
        minValue = $.datepicker.parseDate("yy-mm-dd", minValue);
        minValue.setDate(minValue.getDate()+1);
        $("#end").datepicker( "option", "minDate", minValue );
    })
});