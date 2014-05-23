function showFeeder () {

		/* TO DO Replace url variable with non development server one */
		var url = "sym/pub-sym.json";
		var id = $(this).attr("id");

		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'json',
		}).success(function(tweets) {
		
			var keys = Object.keys(tweets);			
			
			/* For non simulation purposes:
				if(keys.length == 3)
			*/
			if(true)
			{
				/*
				if(keys[0] == "id" && keys[1]== "username" && keys[2] == "content")
				{
				*/

					/* For simulation purposes only, username and pub will loaded trough ajax call */
					var username = $(".pub-owner-"+id).text();
					var pub = $(".pub-content-"+id).val();					
					
					$(".modalShow-tittle").html("<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button><h3 class='text-success'>"+username+" dice:</h3>");
					$(".modalShow-content").html("<blockquote>"+pub+"</blockquote>");
					$('#modalShow').modal("show");
				/*
				}else
					errorShow("Lo sentimos la publicación que intentas ver no existe en nuestros registros.");
				*/
			}else
				errorShow("Lo sentimos la publicación que intentas ver no existe en nuestros registros.");
		}).fail(function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		});
}