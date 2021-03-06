<!DOCTYPE html>
<html lang="es-VE">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Maria Emilia Risi and Jesus Gomez UCV Member">
	<link href="/futbolfanatics/css/bootstrap.min.css" rel="stylesheet">
	<link href="/futbolfanatics/css/all.css" rel="stylesheet">
</head>

<body class="custom-body">

	<!--B Top Menu Zone -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
	<ul class="nav navbar-nav">
		<li><a href="/futbolfanatics/index" class="start-button" >
		<span class="glyphicon glyphicon-home">
		</span>&nbsp;&nbsp;&nbsp;Inicio</a></li>
	</ul>

<!-- 	<form class="navbar-form navbar-left hashtag-search-form"> -->
<!-- 		<div class="form-group"> -->
<!-- 		<input type="text" class="form-control tofind-hashtag" pattern="#[a-zA-Z0-9_-]{3,}" placeholder="hashtag" required/> -->
<!-- 		</div> -->
<!-- 		<button id="hashtag-search" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button> -->
<!-- 	</form>		 -->

	<div class="btn-group options-group">
		<button type="button" class="btn btn-success navbar-btn login-show">Sign in</button>
	</div>
	</div>  		
	</nav>
	<!--E Top Menu Zone -->

	<!--B Tittle Image -->
	<div class="website-tittle-container"><img class="website-tittle" src="img/tittle-1.png"/></div>
	<!--E Tittle Image -->	

	<!--B Site content -->	
	<div class="container-fluid custom-content">

	<div class="col-xs-12 portal-space">

	<div class="jumbotron"><h3 class="text-primary">Comentarios</h3></div>

	<div class="main-container"></div>	

	<span class="btn-group btn-group-lg">
		<button type="button" class="btn btn-danger less-button">-</button>
		<button type="button" class="btn btn-success more-button">+</button>
	</span>	
	</div>
	
	</div>
	<!--E Site content -->


	<!--B Modals Zone -->

	<div class="modal fade" id="modalError">
	<div class="modal-dialog">
	<div class="modal-content">	    	
	<div class="modal-header modalError-tittle">
	<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>
	<h2 class="text-danger">Algo no ha salido bien!!!</h2>
	</div>	
	<div class="text-danger modal-body modalError-content"></div>	      
	<div class="modal-footer modalError-footer"></div>
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
	<div class="modal-footer modalSuccess-footer"></div>
	</div>
	</div>
	</div>

	<div class="modal fade" id="modalShow">
	<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header modalShow-tittle"></div>	      
		<div class="modal-body modalShow-content"></div>	      
		<div class="modal-footer modalShow-footer"></div>
	</div>
	</div>
	</div>

	<div class="modal fade" id="modalLogin">
	<div class="modal-dialog">
	<div class="modal-content">
	<div class="modal-header modalLogin-tittle">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h2 class="text-primary">Iniciar Sesi�n</h2>
	</div>
	<div class="modal-body modalLogin-content">
	<div>
		<p class="login-error-mensaje text-danger"></p> 
	</div>
	<form class="login-form" role="form">					
		<div class="form-group">
		<label for="username-login-field">Usuario</label>
		<input type="text" class="form-control username-login-field" placeholder="Usuario" required/>
		</div>

		<div class="form-group">
		<label for="password-login-field">Contrase�a</label>
		<input type="password" class="form-control password-login-field" placeholder="Contrase�a" required/>
		</div>

		<button type="submit" class="btn btn-primary login-button">Login</button>
		<a class="recover-solicitation-a">�Olvidaste tu contrase�a?</a>
	</form>	

	</div>			
	</div>
	</div>
	</div>
	<!--E Modals Zone -->	

	<script type="text/javascript" src="/futbolfanatics/js/jquery-1.11.0.min.js"></script>	
	<script type="text/javascript" src="/futbolfanatics/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/prototype.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/moreTweets.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/lessTweets.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/showfeeder.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/msgShow.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/login.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/initLoad.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/boot.js"></script>
	<script type="text/javascript">initLoad();</script>
</body>
</html>