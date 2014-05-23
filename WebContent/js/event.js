function eventShow(id){
	
	var url = "sym/event.csv";
		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'text',
		}).success(function(response) {
			var data = $.csv.toObjects(response);
			var i = 0;
			var render = "";
			while(id.length > 0 && i < data.length)
			{
				if(data[i]["id"]== id[0])
				{
					render += "<table class='table event-table'><thead class='event-table-head'><tr><td colspan='2' class='title-"+data[i]["id"]+"'>"+data[i]["title"]+"</td></tr></thead><tfoot><tr><td colspan='2'><span class='btn-group btn-group pull-right'><button type='button' id='"+data[i]["id"]+"' class='btn btn-primary edit-event'>Editar</button><button type='button' id='"+data[i]["id"]+"' class='btn btn-danger del-event'>Eliminar</button></span></td></tr></tfoot><tbody><tr><td colspan='2'><img src="+data[i]["path"]+"></td></tr><tr><td colspan='2'><p class='msg-"+data[i]["id"]+"'>"+data[i]["msg"]+"</p></td></tr><tr><td colspan='1'><p class='date-"+data[i]["id"]+"''>"+data[i]["date"]+"</p></td><td colspan='1'><p class='time-"+data[i]["id"]+"'>"+data[i]["time"]+"</p></td></tr></tbody></table>";
					id.shift();
				}else{
					++i;
				}			
			}
			$(".modalEvent-content").html(render);
			$("#modalEvent").modal("show");

		}).fail(function( jqXHR, textStatus ) {
	  			
	  		alert( "Request failed: " + textStatus );

		});	
}

/*TO DO using server conection*/
function eventCreate(){
	/* Only for simulations purposes */
	$("#modalEventCreate").modal("hide");
	successShow("Tu Evento ha sido exitosamente creado!!!");
}
function eventDelete(id){
	$("#modalEvent").modal("hide");
	$("#modalEventDelete").modal("show");
}
function eventEdit(id){
	$("#modalEvent").modal("hide");
	$(".edit-event-name").val($(".title-"+id).html());	
	$(".edit-event-msg").val($(".msg-"+id).html());

	var strDate = $(".date-"+id).html();
	var strTime = $(".time-"+id).html();
	$(".edit-event-time-date").val(strDate+" "+strTime);
	$("#modalEventEdit").modal("show");
}

function eventEditSend(){
	$("#modalEventEdit").modal("hide");
	successShow("Tu Evento ha sido actualizado creado!!!");
}