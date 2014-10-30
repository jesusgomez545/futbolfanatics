
function addFeeder () {
	var url = "/futbolfanatics/add";

	$.ajax({
		url: url,
		type: 'POST',   		
  		dataType: 'json',
  		data:{"content":$(".content-field").val(), "title":$(".title-field").val()},
	}).success(function(msg) {	
		successShow("Tu plubicacion ha sido exitosamente agregada!!!");
	}).fail(function( jqXHR, textStatus ) {
  		alert( "Request failed: " + textStatus );
	});
}