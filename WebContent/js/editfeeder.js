
function editFeeder () {
	var id = $(this).attr("id");
	$.ajax({
		url: "/futbolfanatics/editar",
		type:'POST',
		datatype: 'json',
		data:{"id": id, "mensaje":$(".content-edit-field").val()},
	}).success(function(response) {
		$(".pub-content-"+id).val($(".content-edit-field").val());
		successShow("Tu publicacion ha sido modificada exitosamente !!!");
	}).fail(function( jqXHR, textStatus ) {
		console.log(jqXHR);
		alert( "Request failed: " + textStatus +"\n"+ jqXHR);
	});
}