
function escapeRegExp(str) {
  return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
}


function replaceAll(toReplace, replaceFor, inputStr) {
  return inputStr.replace(new RegExp(escapeRegExp(toReplace), 'g'), replaceFor);
}


function validateInput (json) {
	var keys;
	try{
		keys = Object.keys(json); keyslen = keys.length;
		if (keyslen == 3)
		{
			if("tagName" == keys[0] && "attrib" == keys[1] && "content" == keys[2])
				return 0;
			else
				return 1;
		}else
			return 3;
	}catch(err){
		return 2;
	}
}

/*********************************************************************************
** 																				**
**	Prototype jsonToHtml()														**
**	======================														**
**																				**
**	input: json structure representation 										**					
**	output: raw html representation 											**
**																				**
**	Usage: 	jsonToHtml([<Html Json Representation>]);							**
**																				**	
**	BNF <Html Json Representation>: 											**
**	==============================												**
**	<attribValue> ::= <htmlValidAttribValue>									**	
**	<definedValue> ::= $l^<JavaScriptVariableName>^$ | <variableValue> 			**
**	<tagName> ::= div|span|table|nav|section|p|h1|h2|h3|h4|h5|h6|...*			**
**	<attrib> ::= class|style|id|type|name|value...* = 							**
**	<content> ::= '['[<template>|definedValue]']' 								**
**	<template> ::= '[' '{' 	tagName : <tagName>,					  			**
**						attrib : <attrib><attribValue>}|'',						**
**						content: <content> '}' ']'								**
**	<Html Json Representation> ::= <template>									**
**																				**
**********************************************************************************/

function jsonToHtml(htmlJsonRepresentation)
{
	var html = '', i=0, len = htmlJsonRepresentation.length, status=0;	
	try{
		for (var i = 0; i < len; ++i) 
		{
			status = validateInput(htmlJsonRepresentation[i]); 
			if(status == 0)
				html+='<'+htmlJsonRepresentation[i].tagName +' '+htmlJsonRepresentation[i].attrib+'>'+jsonToHtml(htmlJsonRepresentation[i].content)+'</'+htmlJsonRepresentation[i].tagName+'>' ;
			else if(status == 2)
				html+= replaceAll('"','',JSON.stringify(htmlJsonRepresentation[i]));
			else
				throw {                
					name:    'SyntaxError',
                	message: "[jsonToHtml]: misformed htmlJsonRepresentation parameter!",              	text:    text
            	}
		}
		return html;
	}catch(err){
		console.error(err);
	}		
}

/*************************************************************************************************
**	dynamicAutoFeed(clss, callback, template)													**
**	=========================================													**
**	- clss: class name of content zone to use as a repeatable zone.								**	
**	- data: feed data, user made, to insert or include any variable value 						**
**				to the repeatable zone 															**
**	- template: format to repeat.																**
**	- pageid: 
**  - page:
**																								**
**	NOTES: 																						**
**	=====																						**
**																								**
**	- IF you want to include some variable's value on the content section of the template, 		**
**	use the $l^<variableName>^$ notation specified above (see BNF <Html Json Representation>) 	**
**																								**
**	- IF you want to include more than a value on a content zone,  use the list notation 		**
** 	(see wrapperX : content:['$l^user^$',' Says!'] )											**
**																								**
**	- IF you want more than one zone use multiple wrapper functions								**
**																								**
**	- IF your repeatable zone has multiple independent tags, each one 							**
**	must be an <Html Json Representation> element of the template list parameters 				**
**																								**
**	- ANY misformed JSON is considered a mistake and will cause the library fails rendering.	**
**																								**	
**	- THE clss tag element must be the inmediate father on DOM hierarchy of the repeatable zone	**
**																								**
**	- THE key name's for the callback function() JSON must be the same that you defined on 		**
**	a $l^<key name>^$ section of content key on the  Html Json Representation(template)			**
**	see(wrapperX example)																		**
**************************************************************************************************/

function dynamicAutoFeed(clss, template, data, pageid, page) 
{

	if (clss == undefined) return "[dynamicAutoFeed]: 'clss' argument not defined!!!";
	if(data == undefined) return "[dynamicAutoFeed]: 'data' argument not defined!!!";
	if(template == undefined)return "[dynamicAutoFeed]: 'template' argument not defined!!!";
	if(page == undefined)return "[dynamicAutoFeed]: 'page' argument not defined!!!";
	if(pageid == undefined)return "[dynamicAutoFeed]: 'pageid' argument not defined!!!";

	var domdest = document.getElementsByClassName(clss);
	try
	{
		if(domdest.length)
		{
			var adding = "", toadd, vars;			
			toadd = data;			

			var toaddN = toadd.length;

			try	{
				vars = Object.keys(toadd[0]);
			}catch(err){
				throw ("[dynamicAutoFeed]: Error while gathering variables names for feed zone (check out callback funtion)!!!"); 
				return;
			}			
			
			var varsN = vars.length;
			var html = '', templateToRender='', formatedTemplate = '', finalTemplate = '';
			
			for(var i=0; i<template.length;++i)
				templateToRender += jsonToHtml([template[i]]);

			for(var i=0;i<toaddN; ++i){
				html = templateToRender;
				for(var j=0;j < varsN; ++j){
					html = replaceAll('$l^'+vars[j]+'^$',toadd[i][vars[j]],html);					
				}
				formatedTemplate +=html;
			}		

			if ( domdest.innerHTML!='' && domdest.innerHTML!=undefined){
				finalTemplate = document.getElementsByClassName(clss).innerHTML;
			}

			finalTemplate += formatedTemplate;
			finalTemplate += '<div class="'+pageid+'" id='+page+'></div>';		

			for(var i =0; i< domdest.length;++i)
				domdest[i].innerHTML = finalTemplate;

		}else
			throw ("[dynamicAutoFeed]: Non existent zone for feed generation!!!");
	}catch(err){
		console.error(err);	
	}		
}