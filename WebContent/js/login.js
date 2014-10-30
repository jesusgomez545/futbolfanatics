function login() {

	$.ajax({
		url: "/futbolfanatics/entrar",
		type: 'POST', 
		datatype:'json',
  		data:{"usuario":$(".username-login-field").val(),"clave":$(".password-login-field").val()},
	}).success(function(response) {
		$("#modalLogin").modal("hide");
		window.location.replace("/futbolfanatics/home");
	}).fail(function( jqXHR, textStatus ) {
		$(".login-error-mensaje").html("Datos de inicio de sesion invalidos");			
	});
}