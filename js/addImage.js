function addImageCreate () {	if($(".new-img").length < 10)	{$(".dynamic-table-create > tbody").append("<tr class='extra-item'><td></td><td>"+$(".container-rep").html()+"</td></tr>");}else{ $('.plus-item-button-create-event').remove();}}
function addImageEdit () {	if($(".new-img").length < 10)	{$(".dynamic-table-edit > tbody").append("<tr class='extra-item'><td></td><td>"+$(".container-rep").html()+"</td></tr>");}else{ $('.plus-item-button-edit-event').remove();}}