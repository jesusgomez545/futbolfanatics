
function loadProfile () {
	var url = 'sym/profile-sym.json';

	$.ajax({
		url: url,
		type: 'GET', 	 		
		dataType: 'json',
		
	}).success(function(response) {
		$(".email-register-field").val(response["email"]);
		$(".username-register-field").val(response["user"]);
		$(".equip-register-field").val(response["equipo"]);
		$(".profile-img-zone").html("<img class='user-profile-img' src="+response["img"]+"/>");		

	}).fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus +"\n"+ jqXHR);
	});
}