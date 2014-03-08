
function editFeeder () {
	var id = $(this).attr("id");
	var oldusername = $(".pub-owner-"+id).text();
	var oldpub = $(".pub-content-"+id).val();
	var newusername = $(".username-edit-field").val();
	var newpub = $(".content-edit-field").val();
	var diff = 0;
	var method = 'put';
	var url = 'http://www.ciens.ucv.ve/ajaxati/tweets/256.json?';
	
	if(newusername != oldusername)
	{
		diff+=2;
		url+="tweet[username]="+newusername;
	}
	if(newpub != oldpub)
	{
		diff+=3;
		if( diff == 5 )
			url+="&";

		url+="tweet[content]="+newpub;
	}

	if(diff == 2 || diff == 3)
		method = 'patch';
	else if (diff == 0)
		return;

	$.ajax({
		url: url,
		type: 'POST', 	 		
		dataType: 'json',
		data: {'_method': method},
	}).success(function(response) {
		$(".pub-owner-"+id).text(newusername);
		$(".pub-content-"+id).val(newpub);
		successShow("Tu publicacion ha sido modificada exitosamente !!!");
	}).fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus +"\n"+ jqXHR);
	});
}