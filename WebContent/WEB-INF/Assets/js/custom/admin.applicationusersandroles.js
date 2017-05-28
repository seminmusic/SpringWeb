$(function () {
	$("#tab-users tr").hover(
		function () {
			$(this).find(".edit-user").show();
		},
		function () {
			$(this).find(".edit-user").hide();
		}
	);
	$("#tab-users .edit-user").click(function () {
		var userId = $(this).data("userId");
		var $tr = $(this).closest("tr");
		$.ajax({
	        type: "GET",
	        url: "/app/admin/app-users-roles/ajax/edit-user",
	        data: { userId: userId },
	        cache: false,
	        beforeSend: function () {
	        	
	        },
	        success: function (partial, textStatus, jqXHR) {
	        	$tr.replaceWith(partial);
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            alert(errorThrown);
	        },
	        complete: function (jqXHR, textStatus) {

	        }
	    });
	});
});

function UpdateAppUser(button) {
	var $forma = $(button).closest("form");
	$.ajax({
        type: "POST",
        url: "/app/admin/app-users-roles/ajax/update-user",
        data: $forma.serialize(),
        cache: false,
        //
        beforeSend: function () {

        },
        success: function (response, textStatus, jqXHR) {
        	var a = 0;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(errorThrown);
        },
        complete: function (jqXHR, textStatus) {

        }
    });
}

function CancelUpdateAppUser(button) {
	alert("Cancel");
}
