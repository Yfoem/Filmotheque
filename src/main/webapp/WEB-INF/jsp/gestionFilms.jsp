<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestion Films</title>
	</head>
	<body>
		<h1>Filmotheque</h1>
		<h2>Gestion Films</h2>
		
		<a href="<%=request.getServletContext().getContextPath()%>/app/ajouterFilm">Ajouter Film</a>
			
		<table>
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
					<td>${f.getRealisteur().getNom()}</td>
					<td>${f.getCategorie().getLibelle()}</td>
					<td>${p.Annee() }</td>
					<td>
						<a href="<%=request.getServletContext().getContextPath()%>/app/modifierFilm?id=${f.getId()}">Modifier</a>
						<a href="<%=request.getServletContext().getContextPath()%>/app/supprimerFilm?id=${f.getId()}">Supprimer</a>
					</td>
				</tr>
			</j:forEach>
		
		</table>
	</body>
</html>