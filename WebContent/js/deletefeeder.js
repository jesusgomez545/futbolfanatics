function deleteFeeder () {
		var id = $(this).attr("id");

		/* TO DO Replace url variable with non development server one */
		var url = "http://www.ciens.ucv.ve/ajaxati/tweets.json";
		
		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'json',
	  		/*
				Use for non simulation purposes:
				type: 'POST',
		  		data: {'_method': 'delete'},
	  		*/
		}).success(function(response) {
			$("#"+id).remove();
		}).fail(function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus +"\n"+ jqXHR);
		});
}