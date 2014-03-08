function showFeeder () {

		/* TO DO Replace url variable with non development server one */
		var url = "http://www.ciens.ucv.ve/ajaxati/tweets/256.json";
		var id = $(this).attr("id");

		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'json',
		}).success(function(tweets) {
			
			var keys = Object.keys(tweets);

			if(keys.length == 3)
			{
				if(keys[0] == "id" && keys[1]== "username" && keys[2] == "content")
				{

					/* For simulation purposes only, username and pub will loaded trough ajax call */
					var username = $(".pub-owner-"+id).text();
					var pub = $(".pub-content-"+id).val();					
					
					$(".modalShow-tittle").html("<h3 class='text-success'>"+username+" dice:</h3>");
					$(".modalShow-content").html("<blockquote>"+pub+"</blockquote>");
					$('#modalShow').modal("show");
				}else
					errorShow("Lo sentimos la publicación que intentas ver no existe en nuestros registros.");	
			}else
				errorShow("Lo sentimos la publicación que intentas ver no existe en nuestros registros.");
		}).fail(function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		});
}