<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="fr.eni.filmotheque.bo.Film"%>
<%@page import="fr.eni.filmotheque.bo.Categorie"%>
<%@page import="fr.eni.filmotheque.bo.Membre"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/accueil.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Accueil</title>
		<%
				
		%>
	</head>
	<body>
		<div class="container-fluid header">
			<div class="row header-text" onclick="">
			    <div class="col">

			    	<h2><a class="noLink" href="<%=request.getContextPath()%>">ENI-Filmothèque</a></h2>


			    </div>
			    <div class="col-6">
			    </div>
			    <div class="col login-section">
			    <%
			    	if(request.getSession().getAttribute("sessionUtilisateur") == null){
			    		%>
			    			<a style="color:#33FFAC;" href="<%=request.getContextPath()%>/app/login"><input class="btn btn-success" type="button" value="Se Connecter"/></a>
			    		<%
			    	}else{
			    		%>
			    			<h3> <%=((Membre)request.getSession().getAttribute("sessionUtilisateur")).getPseudo()%></h3>
			    		<%
			    	}
			    %>
			      
			    </div>
		  	</div>
		  	<br/>
		  	<br/>
		  	<br/>
		  	 	<%
			    	if(request.getSession().getAttribute("sessionUtilisateur") != null &&((Membre)request.getSession().getAttribute("sessionUtilisateur")).EstCreateur() == true ){
			    %>
			    		<a style="color:#33FFAC;" href="<%=request.getContextPath()%>/app/vueAjouterCategorie"><input class="btn btn-success" type="button" value="Gérer Catégories"/></a>

			    		<a style="color:#33FFAC;" href="<%=request.getContextPath()%>/app/gestionParticipant"><input class="btn btn-success" type="button" value="Gérer Participants"/></a>

			    		<a style="color:#33FFAC;" href="<%=request.getContextPath()%>/app/gestionFilms"><input class="btn btn-success" type="button" value="Gérer Films"/></a>
			  			
			  	
			  		<div class="row title-section" >
		  		<h1>Liste des Films</h1>
		  	
		  	</div>
		  	<div class="row films-section">
		  	
			  	<%
			  	List<Film> listeFilm = (List<Film>) request.getAttribute("listeFilms");
			  		if(listeFilm!=null && listeFilm.size()>0){%>
			  			<ul class="list-group" style="margin:100px">
			  			<% for (Film film : listeFilm){
				  			%>	
				  			<li class="list-group-item bg-light" style="padding:40px" >
				  				<form id="<%=film.getId()%>"
										action="<%=request.getServletContext().getContextPath()%>/app/detailFilm?id=<%=film.getId()%>" method="POST">
			  					<div class="film" id="<%=film.getId()%>" onclick="document.getElementById('<%=film.getId()%>').submit();">
				  					<h5 ><strong><%=film.getTitre()%></strong></h5>
<%-- 				  					<p ><%=film.getCategorie().getLibelle()%></p> --%>
<%-- 				  					<p>Année de sortie : <fmt:formatDate value="<%=film.getAnnee()%>" pattern="dd/MM/yyyy" /></p> --%>
				  					<input type="hidden" id="idArticle" name="idArticle" value="<%=film.getId()%>">
			  					</div>
			  					</form>
			  					</li>
				  			<%
				  		}
			  			%>
			  			</ul>
			  	<% 	}
				%>
		  	</div>
		</div>
			  	<% 
			  		}else{
		  	 	%>
		  	 	
		  	 	
		  	<div class="row title-section" >
		  		<h1>Liste des Films</h1>
		  	</div>
		  	<div class="row films-section">
			  	<%
			  	List<Film> listeFilm = (List<Film>) request.getAttribute("listeFilms");
			  		if(listeFilm!=null && listeFilm.size()>0){%>
			  			<ul class="list-group" style="margin:100px">
			  			<% for (Film film : listeFilm){
				  			%>	
				  			<li class="list-group-item bg-light" style="padding:40px" >
				  				<form id="<%=film.getId()%>"
										action="<%=request.getServletContext().getContextPath()%>/app/detailFilm?id=<%=film.getId()%>" method="POST">
			  					<div class="film" id="<%=film.getId()%>" onclick="document.getElementById('<%=film.getId()%>').submit();">
				  					<h5 style="color:#E3AC0D"><strong><%=film.getTitre()%></strong></h5>
<%-- 				  					<p ><%=film.getCategorie().getLibelle()%></p> --%>
<%-- 				  					<p>Année de sortie : <fmt:formatDate value="<%=film.getAnnee()%>" pattern="dd/MM/yyyy" /></p> --%>
				  					<input type="hidden" id="idArticle" name="idArticle" value="<%=film.getId()%>">
			  					</div>
			  					</form>
			  					</li>
				  			<%
				  		}
			  			%>
			  			</ul>
			  	<% 	}}
				%>
		  	</div>
		</div>
	</body>
	<br/>
	<br/>
	<br/>
	<footer>
		<p>Copyrights, All rights reserved</p>
	</footer>
</html>