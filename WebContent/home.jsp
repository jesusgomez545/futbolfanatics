<%@ page import="constantes.Constantes" %>
<!DOCTYPE html>
<html lang="es-VE">
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Maria Emilia Risi and Jesus Gomez UCV Member">		
	<link href="/futbolfanatics/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="/futbolfanatics/css/all.css" rel="stylesheet"/>
	</head>

<body class="custom-body">	

	<!--B Top Menu Zone -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
		<li><a href="/futbolfanatics/home" class="start-button"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;&nbsp;Inicio</a></li>
		<li><a href="/futbolfanatics/profile" class="profile-button"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Perfil</a></li>
		</ul>

<!-- 		<FORM CLASS="NAVBAR-FORM NAVBAR-LEFT HASHTAG-SEARCH-FORM"> -->
<!-- 		<DIV CLASS="FORM-GROUP"> -->
<!-- 			<INPUT TYPE="TEXT" CLASS="FORM-CONTROL TOFIND-HASHTAG"  PATTERN="#[A-ZA-Z0-9_-]{3,}"  PLACEHOLDER="HASHTAG" REQUIRED/> -->
<!-- 		</DIV> -->
<!-- 		<BUTTON ID="HASHTAG-SEARCH" TYPE="SUBMIT" CLASS="BTN BTN-DEFAULT"><SPAN CLASS="GLYPHICON GLYPHICON-SEARCH"></SPAN></BUTTON> -->
<!-- 		</FORM>	 -->

		<div class="btn-group options-group">
		<button type="button" class="btn btn-dfault navbar-btn logout-button">Log Out</button>
		</div>
	</div>  		
	</nav>
	<!--E Top Menu Zone -->

	<!--B Tittle Image -->
	<div class="website-tittle-container"><img class="website-tittle" src="img/tittle-1.png"/></div>
	<!--E Tittle Image -->

	<!--B Site content -->	
	<div class="container-fluid custom-content">

	<div class="col-xs-2 user-space">
	<div class="user-info-container">
	
		<% if (request.getSession().getAttribute("imagen").equals("")) {%>
		<img class="img-circle user-profile-img" src="img/user-img.png"/>		
		<% }else{ %>
		<img class="img-circle user-profile-img" src=<%="\""+Constantes.ASSETS_PATH+"/"+request.getSession().getAttribute("sesion")+"/profile/"+request.getSession().getAttribute("imagen")+"\""%> />
		<%} %>
		
		<div class="username-space">
		<h4>
		<%= request.getSession().getAttribute("sesion") %>
		</h4>
		</div>

		<button type="button" class="btn btn-success publication-button" data-toggle="tooltip" data-placement="bottom" rel="tooltip" title="Crear Publicación">
		<span class="glyphicon glyphicon-comment"></span> 
		</button>
	</div>
	</div>

	<div class="col-xs-10 portal-space">

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
<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>
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

<div class="modal fade" id="modalAdd">
<div class="modal-dialog">
<div class="modal-content">
	<div class="modal-header modalAdd-tittle">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	<h2 class="text-primary">Crear Publicación</h2>
	</div>
	<div class="modal-body modalAdd-content">
	
	
	<table class="table dynamic-table-create-pub">
	<tbody>
	<tr>
	<td>Titulo</td>
	<td><input type="text" class="title-field" required/></td></tr>
	<tr>
	<td>Publicación</td>
	<td><textarea rows="5" cols="40" class="content-field" required/></textarea></td></tr>
	<!-- 
	<tr><td>Imagenes</td>
		<td>
		<div class="container-rep">
		<input type="file" accept="image/*" class="new-img" src="" /></div>
		<button type="button" class="btn btn-primary btn-s plus-item-button-create-pub">+</button>
		</td>
	</tr>
	 -->
	</tbody>
	</table>
	
	
	</div>
	<div class="modal-footer modalAdd-footer">
	<span class="btn-group btn-group">
	<button type="button" class="btn btn-primary pub-button" data-dismiss="modal">Publicar</button>
	<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
	</span>
</div>	
</div>
</div>
</div>

<div class="modal fade" id="modalEdit">
<div class="modal-dialog">
<div class="modal-content">
	<div class="modal-header modalEdit-tittle">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	<h2 class="text-primary">Editar Publicación</h2>
	</div>
	<div class="modal-body modalEdit-content">
	<table class="table">
	<tr><td>Usuario</td><td><p class="username-edit-field"></p></td></tr>
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
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
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
<script type="text/javascript" src="/futbolfanatics/js/prototype.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/moreTweets.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/lessTweets.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/showfeeder.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/editfeeder.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/addfeeder.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/login.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/initLoad.js"></script>
<script type="text/javascript" src="/futbolfanatics/js/boot.js"></script>
<script type="text/javascript">initLoad();</script>
</body>
</html>