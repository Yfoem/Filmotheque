<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.filmotheque.bo.Film"%>
<%@page import="fr.eni.filmotheque.bo.Categorie"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Catégories</title>
</head>
<body>
<% if (request.getAttribute("cat") == null) {%>
	<h1>Gestion des Catégories</h1>
	
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
				<h1> List des Catégories : </h1>
				<%
				for(Categorie cat : listCategorie){
					
		%>
			   <a  href='<%=request.getServletContext().getContextPath() %>/app/vueModifierCategorie?id=<%= cat.getId() %>&label=<%= cat.getLibelle() %>' > <p><%= cat.getLibelle() %></p>
			    
			    
		<%
				}
			}
		%>
	</div>
	<%
	} else {
		
	%>
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
</body>
</html>