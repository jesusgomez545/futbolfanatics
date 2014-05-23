<!DOCTYPE html>
<html lang="es-VE">
<head>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="author" content="Jesus Gomez and Maria Risi UCV Member">		
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/all.css" rel="stylesheet">
</head>

<body class="custom-body">	
	<!--B Top Menu Zone -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="index.html" class="start-button" ><span class="glyphicon glyphicon-home"></span>   Inicio</a></li>
			</ul>

			<form class="navbar-form navbar-left hashtag-search-form">
			  <div class="form-group">
			    <input type="text" class="form-control tofind-hashtag" placeholder="hashtag" required/>
			  </div>
			  <button id="hashtag-search" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
			</form>	

			<div class="btn-group options-group">
			<button type="button" class="btn btn-success navbar-btn login-show">Sign in</button>
			</div>	
  		</div>  		
	</nav>
	<!--E Top Menu Zone -->
	
	<!--B Tittle Image -->
	<div>
	<img class="website-tittle" src="img/tittle-1.png"/></div>
	<!--E Tittle Image -->	
	

	<!--B Site content -->	
	<div class="container-fluid custom-content">
		
		<div class="main-container" >
			<div class="jumbotron">
				<h3 class="text-primary">Restaurar Contraseña</h3>
			</div>

			<div class="small-form-component">
				<form class="restart-solicitation-form" method="POST">
					<table class="table">
						<tbody>
						<tr>
							<td>Nueva Contraseña</td>
							<td><input type="password" class="password-register-field" required/></td>
						</tr>
						<tr>
							<td>Confirmaci&oacute;n de Contraseña</td>
							<td><input type="password" class="password-register-field" required/></td>
						</tr>
						</tbody>
					</table>
					<button type="submit" class="btn btn-primary reset-button">Reset Password</button>
				</form>
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

<div class="modal fade" id="modalLogin">
	<div class="modal-dialog">
	<div class="modal-content">
	<div class="modal-header modalLogin-tittle">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h2 class="text-primary">Iniciar Sesión</h2>
	</div>

	<div class="modal-body modalLogin-content">

	<form class="login-form" role="form">					
		<div class="form-group">
		<label for="username-login-field">Usuario</label>
		<input type="text" class="form-control username-login-field" placeholder="Usuario" required/>
		</div>

		<div class="form-group">
		<label for="password-login-field">Contraseña</label>
		<input type="password" class="form-control password-login-field" placeholder="Contraseña" required/>
		</div>

		<button type="submit" class="btn btn-primary login-button">Login</button>
		<a class="recover-solicitation-a">¿Olvidaste tu contraseña?</a>
	</form>	

	</div>			
	</div>
	</div>
	</div>

	<!--E Modals Zone -->

	
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/msgShow.js"></script>
	<script type="text/javascript" src="js/prototype.js"></script>
	<script type="text/javascript" src="js/moreTweets.js"></script>
	<script type="text/javascript" src="js/lessTweets.js"></script>
	<script type="text/javascript" src="js/showfeeder.js"></script>
	<script type="text/javascript" src="js/editfeeder.js"></script>
	<script type="text/javascript" src="js/addfeeder.js"></script>
	<script type="text/javascript" src="js/deletefeeder.js"></script>
	<script type="text/javascript" src="js/hashtagSearch.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/initLoad.js"></script>
	<script type="text/javascript" src="js/boot.js"></script>

</body>
</html>