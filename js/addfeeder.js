
function addFeeder () {
	var url = "http://www.ciens.ucv.ve/ajaxati/tweets.json?tweet[username]="+$(".username-field").val()+"&tweet[content]="+$(".content-field").val();

	$.ajax({
		url: url,
		type: 'POST',   		
  		dataType: 'json',
	}).success(function(msg) {	
		successShow("Tu plubicación ha sido exitosamente agregada!!!");
	}).fail(function( jqXHR, textStatus ) {
  		alert( "Request failed: " + textStatus );
	});
}