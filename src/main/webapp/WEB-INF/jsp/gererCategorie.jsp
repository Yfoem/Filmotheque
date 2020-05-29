<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.filmotheque.bo.Film"%>
<%@page import="fr.eni.filmotheque.bo.Categorie"%>
<%@page import="fr.eni.filmotheque.bo.Membre"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Catégories</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
		  	<div style="float:right;margin-right:100px">
				<h4><a href="<%=request.getContextPath()%>/app/gestionFilms">Films</a></h4>
				<h4><a href="<%=request.getContextPath()%>/app/vueAjouterCategorie">Catégories</a></h4>
				<h4><a href="<%=request.getContextPath()%>/app/gestionParticipant">Participants</a></h4>
			</div>
	
 <script src="../ressources/js/action.js"></script>
<% if (request.getAttribute("cat") == null) {%>
	<h1>Ajout d'une Catégorie</h1>
	
	<div>		
		<p style="color:red">${error}</p>
		<form action="<%=request.getServletContext().getContextPath() %>/app/ajouterCategorie" method="GET" >
			<div>
				<label for="cat">Catégorie : </label>
				<input type="text" id="cat" name="cat" value="" />
			</div>
			
			<button type="submit">Ajouter</button>
		</form>
	
	</div>
	<br>
	<br>
	<div>
	<%
	List<Categorie> listCategorie = (List<Categorie>) request.getAttribute("sessionCategorie");
			if( listCategorie!= null){
				%>
		  <div class="input-group">
 			 <select class="custom-select" id="selectCat" aria-label="Example select with button addon">
		    <option value="" disabled selected>Catégorie</option>
		  
		    <%
				for(Categorie cat : listCategorie){
					
		%>
			      <option value=<%= cat.getId() %>><%= cat.getLibelle() %></option>
			    
		<%
				}
		%>
			  </select>
			 <div class="input-group-append">
	    		<button onClick="editCategorie();" class="btn btn-outline-secondary" type="button">Button</button>
	  		</div>
  		</div>
		<%
			}
		%>
	</div>
	<%
	} else {
		
	%>
	<h1>Gestion des Catégories</h1>
		<div>		
		<p style="color:red">${error}</p>
		<form action="<%=request.getServletContext().getContextPath() %>/app/modifierCategorie" method="GET" >
			<div>
				<label for="cat">Catégorie : </label>
				<input type="text" id="cat" name="cat" value="${cat.libelle}"/>
				<input type="hidden" id="id" name = "id" value= "${cat.id}"/>
			</div>
			
			<button type="submit">Modifier</button>
		</form>
		
		<a href='<%=request.getServletContext().getContextPath() %>/app/SupprimerCategorie?id=${cat.id}'><p>Supprimer</p>
	
	</div>
	<%
				}
		%>
		</div>
</body>
</html>