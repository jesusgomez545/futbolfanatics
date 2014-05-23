<!DOCTYPE html>
<html lang="es-VE">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Jesus Gomez UCV Member">		
	<link href="/futbolfanatics/css/bootstrap.min.css" rel="stylesheet">
	<link href="/futbolfanatics/css/bic_calendar.css" rel="stylesheet">
	<link href="/futbolfanatics/css/all.css" rel="stylesheet">
	<link href="/futbolfanatics/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>

<body class="custom-body">	

	<!--B Tittle Image -->
	<div><img class="website-tittle" src="/futbolfanatics/img/tittle-1.png"/></div>
	<!--E Tittle Image -->	
	
	<!--B Top Menu Zone -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="home.html" class="start-button" ><span class="glyphicon glyphicon-home"></span>   Inicio</a></li>
    			<li><a href="profile.html" class="profile-button"><span class="glyphicon glyphicon-list-alt"></span>   Perfil</a></li>
			</ul>

			<form class="navbar-form navbar-left hashtag-search-form">
			  <div class="form-group">
			    <input type="text" class="form-control tofind-hashtag"  pattern="#[a-zA-Z0-9_-]{3,}"  placeholder="hashtag" required/>
			  </div>
			  <button id="hashtag-search" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
			</form>

			<div class="btn-group options-group">
			<button type="button" class="btn btn-dfault navbar-btn logout-button">Log Out</button>
			</div>
		</div>  		
	</nav>
	<!--E Top Menu Zone -->

	<!--B Site content -->	
	<div class="container-fluid custom-content">
		<div class="col-xs-12 portal-space">			
			<div class="jumbotron">
				<h3 class="text-primary">Eventos</h3>
			</div>
			<div class="main-container">
				<div class="calendar-container calendar-margin"></div>
				<div class="calendar-margin">
					<button type="button" class="btn btn-success create-event-button">Crear Evento</button>					
				</div>			
			</div>	
		</div>
	</div>
	<!--E Site content -->


<!--B Modals Zone -->

	<div class="modal fade" id="modalError">
	  <div class="modal-dialog">
	    <div class="modal-content">	    	
	    	<div class="modal-header modalError-tittle">
	    		<h2 class="text-danger">Algo no ha salido bien!!!</h2>
	    	</div>	
		    <div class="text-danger modal-body modalError-content"></div>	      
	    	<div class="modal-footer modalError-footer">
	    	<button type="button" class="btn btn-danger" data-dismiss="modal">x</button>
	      	</div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="modalSuccess">
	  <div class="modal-dialog">
	    <div class="modal-content">	    	
	    	<div class="modal-header modalSuccess-tittle">
	    		<h2 class="text-success">Todo ha salido bien!!!</h2>
	    	</div>	
		    <div class="text-success modal-body modalSuccess-content"></div>	      
	    	<div class="modal-footer modalSuccess-footer">
	    	<button type="button" class="btn btn-success" data-dismiss="modal">x</button>
	      	</div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="modalEvent">
	  <div class="modal-dialog">
	    <div class="modal-content">	      
	      <div class="modal-header modalEvent-tittle">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	     <h2 class="text-primary">Eventos</h2></div>
	     <div class="modal-body modalEvent-content"></div>
	      <div class="modal-footer modalEvent-footer">
	      <div class="btn-group">	        
	      </div>
	      </div>

	    </div>
	  </div>
	</div>

	
<div class="modal fade" id="modalEventCreate">
	<div class="modal-dialog">
	<div class="modal-content">	      
			<div class="modal-header modalEventCreate-tittle">
				<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>
				<h2 class="text-primary">Crear Evento</h2>
			</div>	      

		<div class="modal-body modalEventCreate-content">
			<form class="createEvent-form" method="POST">
				<table class="table dynamic-table-create">
				<tbody>
					<tr>
					<td>Nombre del Evento</td>
					<td><input type="text" class="new-event-name" required/></td>
					</tr>

					<tr>
					<td>Fecha y Hora</td>
					<td>					
					<div id="datetimepicker" class="date">					
					<input data-format="dd/MM/yyyy hh:mm:ss" type="text" class="new-event-time-date" required/>
					<span class="add-on"> <i data-time-icon="glyphicon glyphicon-time" data-date-icon="glyphicon glyphicon-calendar"></i></span>
					</div>
					</td>
					</tr>

					<tr>
					<td>Mensaje de invitaci√≥n</td>
					<td>
					<textarea rows="5" cols="40" class="new-event-msg" placeholder="PublicaciÛn" required></textarea>		
					</td>
					</tr>
				
					<tr>
					<td>Imagenes</td>
					<td><div class="container-rep">
						<input type="file" accept="image/*" class="new-img" src="" required/>
						</div>
						<button type="button" class="btn btn-primary btn-s plus-item-button-create-event">+</button>
					</td>
					</tr>	
				</tbody>   
				</table>
			<button type="submit" class="btn btn-primary pub-event-button pull-right">Publicar</button>
			</form>   	
		</div>	
		<div class="modal-footer modalEventCreate-footer"></div>
</div>
</div>
</div>
		

<div class="modal fade" id="modalEventEdit">
	<div class="modal-dialog">
	<div class="modal-content">	      
	<div class="modal-header modalEventEdit-tittle">
	<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>
	<h2 class="text-primary">Editar Evento</h2>
	</div>	      
	<div class="modal-body modalEventEdit-content">
		<form class="editEvent-form" method="POST">
			<table class="table dynamic-table-edit">
				<tbody>
				<tr><td>Nombre del Evento</td>
				<td><input type="text" class="edit-event-name" required/></td>
				</tr>
				<tr><td>Fecha y Hora</td>
				<td>					
  				<div id="datetimepicker-edit" class="date">					
   				<input data-format="dd/MM/yyyy hh:mm:ss" type="text" class="edit-event-time-date" required/>
  				<span class="add-on"> <i data-time-icon="glyphicon glyphicon-time" data-date-icon="glyphicon glyphicon-calendar"></i></span>
  				</div>
				</td>
				</tr>
				<tr><td>Mensaje de invitaci√≥n</td>
				<td>
					<textarea rows="5" cols="40" class="edit-event-msg" placeholder="PublicaciÛn" required/></textarea>
					</td>
				</tr>
				
				<tr><td>Imagenes</td>
				<td><div class="container-rep">
				<input type="file" accept="image/*" class="new-img" src="" required/></div>
				<button type="button" class="btn btn-primary btn-s plus-item-button-edit-event">+</button>
				</td>
				</tr>
			</tbody>   
			</table> 
			<button type="submit" class="btn btn-primary pull-right">Guardar</button>
			</form> 	
		</div>		
		<div class="modal-footer modalEventEdit-footer"></div>
		</div>
		</div>
		</div>

<div class="modal fade" id="modalEventDelete">
<div class="modal-dialog">
<div class="modal-content">            
	<div class="modal-header modalEventDelete-tittle">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	<h2 class="text-primary">Eliminar Evento</h2>
	</div>
	<div class="modal-body modalEventDelete-content">
	<p>Realmente deseas Eliminar este Evento?</p>
	</div>
	<div class="modal-footer modalEventDelete-footer">
	<span class="btn-group btn-group">
	<button type="button" class="btn btn-primary delete-button" data-dismiss="modal">Eliminar</button>
	<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
	</span>
	</div>        
</div>
</div>
</div>

<!--E Modals Zone -->
	
	<script type="text/javascript" src="/futbolfanatics/js/jquery-1.11.0.min.js"></script>	
	<script type="text/javascript" src="/futbolfanatics/js/jquery.csv-0.71.min.js"></script>	
	<script type="text/javascript" src="/futbolfanatics/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/msgShow.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/prototype.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/moreTweets.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/lessTweets.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/showfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/editfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/addfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/addImage.js"></script>	
	<script type="text/javascript" src="/futbolfanatics/js/deletefeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/hashtagSearch.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/login.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/initLoad.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/bic_calendar.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/calendar.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/event.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/boot.js"></script>
	<script type="text/javascript">initCalendar();</script>



</body>
</html>