function modifyProfile () {

	/* URL que brindara servicio de registro del lado del servidor */
	var url = '';
	
	var teams = [];

	$(".equip-register-field").each(function( e) {
  		teams.push($(this).val());
  	})

	$.ajax({
		url: url,
		type: 'POST', 

		/* Data a ser enviada al momento del registro */	 		
		data : {"email":$(".email-register-field").val(),
			"user":$(".username-register-field").val(),			
			"equipos":teams,
			/*TO DO improve upload image method*/
			"img":$(".profile-img-zone").val()}
	} ).success(function(response) {
		
		//window.location.replace("/home");
	
	}).fail(function( jqXHR, textStatus ) {

		//alert( "Request failed: " + textStatus );

		/* Solo para fines de simulacion: */
		window.location.replace("home.html");		
	});
}