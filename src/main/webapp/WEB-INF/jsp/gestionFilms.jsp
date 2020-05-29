<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.filmotheque.bo.Film"%>
<%@page import="fr.eni.filmotheque.bo.Categorie"%>
<%@page import="fr.eni.filmotheque.bo.Participant"%>

    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestion Films</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<style type="text/css">
		.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
  font-weight: bold;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
  background-color: #1e90ff;
}
		</style>
	</head>
	<body>
	
		<h1>Filmotheque</h1>
		<h2>Gestion Films</h2>
		
		
		
		<%
		List<Categorie> categories = ( List<Categorie>) request.getAttribute("listeCategories");	  
		List<Participant> participants = ( List<Participant>) request.getAttribute("listeParticipants");
		if(request.getAttribute("film")==null){
						
		%>	
		<h3>Ajouter Film</h3>
		
		<form  action="<%=request.getServletContext().getContextPath()%>/app/ajouterFilm" method="POST">
			 
			<label>Titre:</label>
		    <input type="text" name="titre" /><br>
		    
		    <label>Année:</label>
		    <input type="date" name="annee" /><br>
		    
		    <label>Categorie</label><br>
			<select name="categorie">
			<%
			  			for (Categorie categorie : categories){
			%>	
			<option value=<%=categorie.getId()%> selected="selected"><%=categorie.getLibelle()%></option>
				<%
			  			}
				%>
				
			</select><br>
			
			<label>Realisateur</label><br>
			<select name="realisateur">
			<%
			  			for (Participant participant : participants){
			%>	
			<option value=<%=participant.getId()%> selected="selected"><%=participant.getNom()%> <%=participant.getPrenom()%></option>
				<%}%>
			
			</select><br>
			
			<label>Acteurs:</label><br>
			<select id="acteur" name="Acteur" >
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
			 
				<label>Titre:</label>
		    <input type="text" name="titre" value=<%=film1.getTitre() %>><br>
		    
		    <label>Année:</label>
		    <input type="date" name="annee" value="<%=film1.getAnnee() %>"/><br>
		    
		    <label>Categorie : <%=film1.getCategorie().getLibelle() %></label>
			<select name="categorie">
			<%
			  	
			  			for (Categorie categorie : categories){
			%>	
			<option value=<%=categorie.getId()%> selected="selected"><%=categorie.getLibelle()%></option>
				<%
			  			}
				%>
				
			</select><br>
			
			<label>Realisateur : <%=film1.getRealisteur().getNom() %>  <%=film1.getRealisteur().getPrenom() %></label>
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
		
	
		<a href="<%=request.getServletContext().getContextPath()%>/app/ajouterFilm">Ajouter Film</a>
			
		<table class="table table-dark">
			<tr>
				<th>Titre</th>
				<th>RÃ©alisateur</th>
				<th>CatÃ©gorie</th>
				<th>Date de sortie</th>
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
		
		
	</body>
	

</html>