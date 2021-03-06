<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.filmotheque.bo.Film"%>
<%@page import="fr.eni.filmotheque.bo.Categorie"%>
<%@page import="fr.eni.filmotheque.bo.Participant"%>
<%@page import="fr.eni.filmotheque.bo.Membre"%>

    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/accueil.css">
		<meta charset="ISO-8859-1">
		<title>Gestion Films</title>
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
		<h2>Gestion Films</h2>
		
		
		
		<%
		List<Categorie> categories = ( List<Categorie>) request.getAttribute("listeCategories");	  
		List<Participant> participants = ( List<Participant>) request.getAttribute("listeParticipants");
		if(request.getAttribute("film")==null){
						
		%>	
		<h3>Ajouter Film</h3>
		
		<form  action="<%=request.getServletContext().getContextPath()%>/app/ajouterFilm" method="POST">
			 
			<label>Titre :</label>
		    <input type="text" name="titre" /><br>
		    
		    <label>Année:</label>
		    <input type="date" name="annee" /><br>
		    
		    <label>Catégorie</label><br>
			<select name="categorie">
			<%
			  			for (Categorie categorie : categories){
			%>	
			<option value=<%=categorie.getId()%> selected="selected"><%=categorie.getLibelle()%></option>
				<%
			  			}
				%>
				
			</select><br>
			
			<label>Réalisateur</label><br>
			<select name="realisateur">
			<%
			  			for (Participant participant : participants){
			%>	
			<option value=<%=participant.getId()%> selected="selected"><%=participant.getNom()%> <%=participant.getPrenom()%></option>
				<%}%>
			
			</select><br>
			<input type="submit" value="Ajouter">
			
			</form>
		<%}else{
			
			Film film1 = (Film)request.getAttribute("film");
%>	
		
			
			<h3>Modifier Film | <%=film1.getTitre() %> </h3>
		
		<form  action="<%=request.getServletContext().getContextPath()%>/app/modifierFilm?id=<%=film1.getId() %>" method="POST">
			 
				<label>Titre :</label>
		    <input type="text" name="titre" value=<%=film1.getTitre() %>/><br>
		    
		    <label>Année :</label>
		    <input type="date" name="annee" value="<%=film1.getAnnee() %>"/><br>
		    
		    <label>Catégorie : <%=film1.getCategorie().getLibelle() %></label>
			<select name="categorie">
			<%
			  	
			  			for (Categorie categorie : categories){
			%>	
			<option value=<%=categorie.getId()%> selected="selected"><%=categorie.getLibelle()%></option>
				<%
			  			}
				%>
				
			</select><br>
			
			<label>Réalisateur : <%=film1.getRealisteur().getNom() %>  <%=film1.getRealisteur().getPrenom() %></label>
			<select name="realisateur">
			<%
			  			for (Participant participant : participants){
			%>	
			<option value=<%=participant.getId()%> selected="selected"><%=participant.getNom()%> <%=participant.getPrenom()%></option>
				<%}%>
			
			</select><br>
			<input type="submit" value="Modifier"><br>
			
			</form>
			
			
		<%
		}
		%>
			<br>
			<br>
		<table class="table table-dark">
			<tr>
				<th>Titre</th>
				<th>Réalisateur</th>
				<th>Catégorie</th>
				<th>Année sortie</th>
				<th>Actions</th>
			
			</tr>
			
			<j:forEach items="${films}" var="f">
				<tr>
					<td>${f.getTitre()}</td>
					<td>${f.getRealisteur().getNom()} ${f.getRealisteur().getPrenom()}</td>
					<td>${f.getCategorie().getLibelle()}</td>
					<td>${f.getAnnee() }</td>
					<td>
						<a href="<%=request.getServletContext().getContextPath()%>/app/modifierFilm?id=${f.getId()}">Modifier</a>
						<a href="<%=request.getServletContext().getContextPath()%>/app/supprimerFilm?id=${f.getId()}">Supprimer</a>
					</td>
				</tr>
			</j:forEach>
		
		</table>
		</div>
	</body>
</html>