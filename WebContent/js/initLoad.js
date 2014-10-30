
function initLoad() {
	
	$.ajax({
		url: "/futbolfanatics/pubs",
		type: 'GET', 	 		
  		datatype: 'json',
  		data:{"p":0},
	}).success(function(response) {
		var template = [
		{tagName:'div',attrib:'id="$l^id^$" class="mc0"',content:[
			{tagName:'div',attrib:'class="user-zone"',content:[
				{tagName:'h4',attrib:'class="text-primary pub-owner-$l^id^$"',content:["$l^nombreUsuario^$",]},
				{tagName:'h5',attrib:'style="margin-left:75%;" class="text-success pub-time-$l^id^$"',content:["$l^fechaPublicacion^$",]},
			]},
			{tagName:'input',attrib:'class="pub-content-$l^id^$" value="$l^mensaje^$" maxlength="10" readonly',content:[]},
			{tagName:'div',attrib:'class="btn-group options-group"',content:[
				{tagName:'button',attrib:'id="$l^id^$" type="button" class="btn btn-primary show-button"',content:["Show"]},
				{tagName:'button',attrib:'id="$l^id^$" type="button" class="btn btn-primary edit-button"',content:["Edit"]},
			]},]},
		]	
		dynamicAutoFeed('main-container',template, response, 'pageid-zone', 0);
	}).fail(function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
	});	
}

