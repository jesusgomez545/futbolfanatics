function loginSym() {

	$("#modalLogin").modal("hide");
	var url = "sym/login-sym.json";

	$.ajax({
		url: url,
		type: 'GET', 	 		
  		dataType: 'json',
	}).success(function(response) {

		var user = $(".username-login-field").val();
		var pass = $(".password-login-field").val();
		
		//Simulacion proceso de autenticacion
		if(response[user]==pass)
			window.location.replace("home.html");	
		else
			errorShow("Datos de inicio de sesión invalidos.");
		
	}).fail(function( jqXHR, textStatus ) {
  			
		alert( "Request failed: " + textStatus );
	});
}