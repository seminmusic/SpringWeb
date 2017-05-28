$(function() {
	$("#tab-users tr").hover(
		function() {
			$(this).find(".edit-user").show();
		},
		function() {
			$(this).find(".edit-user").hide();
		}
	);
	$("#tab-users .edit-user").click(function() {
		var userId = $(this).data("userId");
		var $tr = $(this).closest("tr");
		$.ajax({
	        type: "GET",
	        url: "/app/admin/app-users-roles/ajax/edit-user",
	        data: { userId: userId },
	        cache: false,
	        success: function (partial) {
	        	$tr.replaceWith(partial);
	        },
	        complete: function () {

	        }
	    });
	});
});
