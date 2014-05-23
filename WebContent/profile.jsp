<!DOCTYPE html>
<html lang="es-VE">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="author" content="Maria Emilia Risi and Jesus Gomez UCV Member"/>		
	<link href="/futbolfanatics/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="/futbolfanatics/css/all.css" rel="stylesheet"/>
</head>

<body class="custom-body">	

	<!--B Top Menu Zone -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="home.html" class="start-button" ><span class="glyphicon glyphicon-home"></span>   Inicio</a></li>
    			<li><a href="profile.html" class="profile-button"><span class="glyphicon glyphicon-list-alt"></span>   Perfil</a></li>
			</ul>

			<form class="navbar-form navbar-left hashtag-search-form">
			  <div class="form-group">
			    <input type="text" class="form-control tofind-hashtag"  pattern="#[a-zA-Z0-9_-]{3,}" placeholder="hashtag" required/>
			  </div>
			  <button id="hashtag-search" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
			</form>	

			<div class="btn-group options-group">
			<button type="button" class="btn btn-dfault navbar-btn logout-button">Log Out</button>
			</div>	
  		</div>  		
	</nav>
	<!--E Top Menu Zone -->
	
	<!--B Tittle Image -->
	<div class="website-tittle-container"><img class="website-tittle" src="/futbolfanatics/img/tittle-1.png"/></div>
	<!--E Tittle Image -->

	<!--B Site content -->	
	<div class="container-fluid custom-content">
		
		<div class="main-container">
			
			<div class="jumbotron"><h3 class="text-primary">Perfil</h3></div>
			<form class="modify-form" method="POST">

				<table class="table dynamic-table">
				<tbody>
				
				<tr>
					<td>Email</td>
					<td><input type="email" class="email-register-field"name="email" placeholder="user@domain.any" required /></td>
				</tr>

				<tr>
					<td>Usuario</td>
					<td><input type="text" class="username-register-field" required/></td>
				</tr>

				<tr>
					<td>Imagen de Perfil</td>
					<td>
					<div class="profile-img-zone"></div>
					<input type="file" accept="image/*" class="image-profile-field image-register-field" src="" required/>
					<button type="button" class="btn btn-primary img-register-button">Cambiar Imagen</button>
					</td>	
				</tr>

				<tr>
					<td>Equipo(s) Favorito(s)</td>
					<td >
						<div class="container-rep">
							<select class="equip-register-field" required>
								<option value="">-Choose-</option>
								<option value="Alemania">Alemania</option>
								<option value="Argelia">Argelia</option> 
								<option value="Argentina">Argentina</option> 
								<option value="Australia">Australia</option> 
								<option value="Bélgica">Bélgica</option> 
								<option value="Brasil">Brasil</option> 
								<option value="Bosnia">Bosnia</option> 
								<option value="Camerún">Camerún</option> 
								<option value="Chile">Chile</option> 
								<option value="Colombia">Colombia</option> 
								<option value="Corea del Sur">Corea del Sur</option> 
								<option value="Costa de Marfil">Costa de Marfil</option> 
								<option value="Costa Rica">Costa Rica</option> 
								<option value="Croacia">Croacia</option> 	
								<option value="Ecuador">Ecuador</option>
								<option value="España">España</option>
								<option value="Estados Unidos">Estados Unidos</option> 
								<option value="Francia">Francia</option> 
								<option value="Ghana">Ghana</option> 
								<option value="Grecia">Grecia</option> 
								<option value="Holanda">Holanda</option> 
								<option value="Honduras">Honduras</option> 
								<option value="Italia">Italia</option> 
								<option value="Inglaterra">Inglaterra</option>
								<option value="Irán">Iran</option> 
								<option value="Japón">Japón</option> 
								<option value="México">México</option>
								<option value="Nigeria">Nigeria</option>				 
								<option value="Portugal">Portugal</option>
								<option value="Rusia">Rusia</option>  
								<option value="Suiza">Suiza</option>
								<option value="Uruguay">Uruguay</option>
							</select>
						</div>
						<button type="button" class="btn btn-primary btn-s plus-team-button">+</button>
						</td>
					</tr>
				</tbody>
				</table>

				<button type="submit" class="btn btn-primary modify-button">Guardar</button>
				</form>			    
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

	<div class="modal fade" id="modalShow">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      
	      <div class="modal-header modalShow-tittle"></div>	      
	      <div class="modal-body modalShow-content"></div>	      
	      <div class="modal-footer modalShow-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">x</button>
	      </div>

	    </div>
	  </div>
	</div>

	<div class="modal fade" id="modalEdit">
	<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header modalEdit-tittle">
		<h2 class="text-primary">Editar Publicación</h2>
		</div>
		<div class="modal-body modalEdit-content">
		<table class="table">
		<tr><td>Usuario</td><td><input type="text" class="username-edit-field" placeholder="Usuario" required/></td></tr>
		<tr><td>Publicación</td><td><textarea rows="5" cols="40" class="content-edit-field" placeholder="Publicación" required></textarea></td></tr>	    			
		</table>
		</div>
		<div class="modal-footer modalEdit-footer">
		<span class="btn-group btn-group">
		<button type="button" class="btn btn-primary edition-ready-button" data-dismiss="modal">Listo</button>
		<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
		</span>
	</div>	
	</div>
	</div>
	</div>

	<div class="modal fade" id="modalDelete">
	<div class="modal-dialog">
	<div class="modal-content">            
		<div class="modal-header modalDelete-tittle">
		<h2 class="text-primary">Eliminar Publicación</h2>
		</div>
		<div class="modal-body modalDelete-content">
		<p>Realmente deseas Eliminar esta Publicación?</p>
		</div>
		<div class="modal-footer modalDelete-footer">
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
	<script type="text/javascript" src="/futbolfanatics/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/msgShow.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/prototype.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/showfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/editfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/deletefeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/hashtagSearch.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/login.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/initLoad.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/boot.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/loadprofile.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/modify.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/loadTeams.js"></script>
	<script type="text/javascript">loadProfile();</script>
</body>
</html>