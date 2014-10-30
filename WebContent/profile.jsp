<%@page import="modelos.*"%>
<%@ page import="constantes.Constantes" %>
<%@page import="java.util.ArrayList"%>
<%
	Registrado u = (Registrado)request.getAttribute("perfil");
	ArrayList<Equipo> e = (ArrayList)request.getAttribute("equipos");
	ArrayList<Equipo> f = (ArrayList)request.getAttribute("favoritos");
%>


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
				<li><a href="/futbolfanatics/home" class="start-button" ><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;&nbsp;Inicio</a></li>
    			<li><a href="/futbolfanatics/profile" class="profile-button"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;Perfil</a></li>
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
			<form class="modify-form" method="POST" enctype="multipart/form-data" action="/futbolfanatics/editprofile">

				<table class="table dynamic-table">
				<tbody>
				
				<tr>
					<td>Email</td>
					<td><input type="email" class="email-register-field" name="email" placeholder="user@domain.any" value=<%="\""+u.getCorreo()+"\"" %>	required /></td>
				</tr>

				<tr>
					<td>Usuario</td>
					<td>
					<p><%=u.getNombreUsuario()%></p></td>
				</tr>

				<tr>
					<td>Imagen de Perfil</td>
					<td>
					<div class="profile-img-zone"></div>
					<img class="profile-img" src=<%="\""+Constantes.ASSETS_PATH+"/"+request.getSession().getAttribute("sesion")+"/profile/"+request.getSession().getAttribute("imagen")+"\""%>/>
					<input type="file" name ="profileImage" id="profileImage" accept="image/*" src="" required/>					
					</td>	
				</tr>

				<tr>
					<td>Equipo(s) Favorito(s)</td>
					<%for(int k =0; k<f.size();++k) {%>
						
						
						<%if (k==0) {%>
						<td ><div class="container-rep">
						<%}else{%>
						<tr><td></td><td>
						<%} %>						
							<select class="equip-register-field" name="team" required>
								<option value="">-Choose-</option>		
								<% for(Equipo i : e) {%>								
								<option value=<%="\""+i.getNombre()+"\"" %>								
								<%if(f.get(k).getNombre().equals(i.getNombre())){ %>selected<%} %>>
								<%=i.getNombre()%>
								</option>
								<%} %>
							</select>
						<%if (k==0) {%>
						</div><button type="button" class="btn btn-primary btn-s plus-team-button">+</button></td></tr>
						<%} else{%>
						</td></tr>
						<%} %>						
					<%} %>	
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

	<!--E Modals Zone -->

	<script type="text/javascript" src="/futbolfanatics/js/jquery-1.11.0.min.js"></script>	
	<script type="text/javascript" src="/futbolfanatics/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/msgShow.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/boot.js"></script>
	<script type="text/javascript" src="/futbolfanatics/js/loadTeams.js"></script>
</body>
</html>