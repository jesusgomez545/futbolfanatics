function errorShow(msg)
{
	$(".modalError-content").html(msg);
	$('#modalError').modal("show");	
}

function successShow(msg)
{
	$(".modalSuccess-content").html(msg);
	$('#modalSuccess').modal("show");
}