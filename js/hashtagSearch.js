function hashtagSearch() {
	var hashtag = $(".tofind-hashtag").val();
	var url = "sym/hashtag-sym.json";

	$.ajax({
		url: url,
		type: 'GET', 	 		
		dataType: 'json',
		data : {'hashtag':hashtag},
	}).success(function(response) {
		
		//Simulacion de busqueda de hashtag en respuesta del servidor.
		try{
			if ( response[hashtag]== undefined )
				throw ("[hashtagSearch]Error while gatering hashtag data!!!"); 
			
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
			
			var page = 1;
			dynamicAutoFeed('main-container',template, response[hashtag], 'pageid-zone', page);

		}catch(err){
			errorShow("El hashtag que intentas buscar no existe en nuestros registros.");			
		}

	}).fail(function( jqXHR, textStatus ) {
  			
		alert( "Request failed: " + textStatus );
	});
}