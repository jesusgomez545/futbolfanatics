function lessTweets(pageid) {

	try	{
		var page = parseInt($('.'+pageid).attr("id"))-1;
	}catch(err){
		throw ("[lessTweets]: Error while gathering page number identifier!!!"); 
		return;
	}

	if(page > 0)
	{
		var url = "sym/pub-sym.json";

		/* For pagination purposes use: ?page="+page.toString(); */
		
		$.ajax({
			url: url,
			type: 'GET', 	 		
	  		dataType: 'json',
		}).success(function(response) {

			var template = [
			{tagName:'div',attrib:'id="$l^id^$" class="mc0"',content:[
				{tagName:'div',attrib:'class="user-zone"',content:[
					{tagName:'h4',attrib:'class="text-primary pub-owner-$l^id^$"',content:["$l^username^$",]},
				]},
				{tagName:'input',attrib:'class="pub-content-$l^id^$" value="$l^content^$" maxlength="10" readonly',content:[]},
				{tagName:'div',attrib:'class="btn-group options-group"',content:[
					{tagName:'button',attrib:'id="$l^id^$" type="button" class="btn btn-primary show-button"',content:["Show"]},
					{tagName:'button',attrib:'id="$l^id^$" type="button" class="btn btn-primary edit-button"',content:["Edit"]},
					{tagName:'button',attrib:'id="$l^id^$" type="button" class="btn btn-primary del-button"',content:["Delete"]},
				]},]},
			]

			dynamicAutoFeed('main-container',template, response["pubs"], 'pageid-zone', page);
		}).fail(function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		});	
	}else
		successShow("Lo sentimos no existen publicaciones mas antiguas");
}