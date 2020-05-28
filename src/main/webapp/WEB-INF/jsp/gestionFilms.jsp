<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestion Films</title>
	</head>
	<body>
		<h1>Filmotheque</h1>
		<h2>Gestion Films</h2>
			
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
					<td>${f.getRealisateur().getNom()}</td>
					<td>${f.getCategorie().getLibelle}</td>
					<td>${p.Annee() }</td>
					<td>
						<a href="<%=request.getServletContext().getContextPath()%>/app/modifierParticipant?id=${p.getId()}">Modifier</a>
						<a href="<%=request.getServletContext().getContextPath()%>/app/supprimerParticipant?id=${p.getId()}">Supprimer</a>
					</td>
				</tr>
			</j:forEach>
		
		</table>
	</body>
</html>