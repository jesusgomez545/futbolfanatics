function initCalendar() {

	var url = "sym/event-sym.json";

	$.ajax({
		url: url,
		type: 'GET', 	 		
  		dataType: 'json',
	}).success(function(events) {

		var monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    	var dayNames = ["L", "M", "M", "J", "V", "S", "D"];  

    	$(".calendar-container").bic_calendar({
        events: events["events"],
        enableSelect: true,
        multiSelect: true,
        dayNames: dayNames,
        monthNames: monthNames,
        showDays: true,
        displayMonthController: true,
        displayYearController: true,

        /*Ajax call that would load more events if month/year controller is used
		reqAjax: {
			type: 'get',
			url: 'http://bic.cat/bic_calendar/index.php'
		} */ 
    	});
		
	}).fail(function( jqXHR, textStatus ) {
  			
		alert( "Request failed: " + textStatus );
	});
}