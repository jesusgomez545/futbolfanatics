function showFeeder () {
		var id = $(this).attr("id");

		$.ajax({
			url: "/futbolfanatics/mostrar",
			type: 'GET', 	 		
	  		datatype: 'json',
	  		data:{"id":id},
		}).success(function(response) {
		
			console.log(response);
			$(".modalShow-tittle").html("<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button><h3 class='text-success'>"+response["nombreUsuario"]+" dice:</h3>");
			$(".modalShow-content").html("<blockquote>"+response["mensaje"]+"</blockquote>");
			$('#modalShow').modal("show");
				
		}).fail(function( jqXHR, textStatus ) {
			errorShow("Lo sentimos la publicación que intentas ver no existe en nuestros registros.");
		});
}