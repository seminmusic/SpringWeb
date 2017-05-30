$(function () {
	BindEventsForTabUsers();
});


function BindEventsForTabUsers() {
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
	        	$("#tab-users tr.tr-edit[data-user-id='" + userId + "']")
	        		.find("form")
	        		.bootstrapValidator()
	        		.on("success.form.bv", function (event) {
	        			// Prevent form submission:
	        			event.preventDefault();
	        			// Get the form instance:
	        			var $forma = $(event.target);
	        			//
	        			UpdateAppUser($forma);
	        		});
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.responseText);
	        },
	        complete: function (jqXHR, textStatus) {
	        	
	        }
	    });
	});
}

function UpdateAppUser($forma) {
	// $forma.bootstrapValidator("validate");  // Validate the form manually
	$.ajax({
        type: "POST",
        url: "/app/admin/app-users-roles/ajax/update-user",
        data: $forma.serialize(),
        cache: false,
        //
        beforeSend: function () {

        },
        success: function (partial, textStatus, jqXHR) {
        	$("#tab-users").empty();
        	$("#tab-users").html(partial);
        	BindEventsForTabUsers();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        },
        complete: function (jqXHR, textStatus) {

        }
    });
}

function CancelUpdateAppUser(button) {
	$.ajax({
        type: "GET",
        url: "/app/admin/app-users-roles/ajax/cancel-update-user",
        cache: false,
        beforeSend: function () {
        	
        },
        success: function (partial, textStatus, jqXHR) {
        	$("#tab-users").empty();
        	$("#tab-users").html(partial);
        	BindEventsForTabUsers();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        },
        complete: function (jqXHR, textStatus) {
        	
        }
    });
}
