function eventShow(id, data){
	/* data attribute is defined only for simulation purposes	*/
	/* it must be using get method and id attribute				*/
	
	var url = "sym/event-sym.json";

	/* For simulation purposes only */
	if(data["tittle"]!=undefined && data["content"]!= undefined){

		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'json',
		}).success(function(response) {

			if(response["events"].length > 0)
			{
				
					var date = data["date"].split("/");			
		 			$(".modalEvent-tittle").html(data["tittle"]+"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>");
		 			$(".event-date-field").html("<h2>"+date[1]+" / "+date[0]+" / "+date[2]+"</h2>");
		 			$(".event-img-field").html("<img src='img/ei1.png'/>");
		 			$(".event-content-field").html("<h4>"+data["content"]+"</h4>");
		 			$("#modalEvent").modal("show");
		 	}
			else{
				errorShow("El evento que intentas ver no existe!!!");
			}

		}).fail(function( jqXHR, textStatus ) {
	  			
	  		alert( "Request failed: " + textStatus );

		});
	}
}

function eventCreate(){}

function eventDelete(id){}

function eventEdit(id){}

function reDrawEdit (data, flag) {
	if(flag == "show")
	{}
	else if(flag == "edit")
	{}
}