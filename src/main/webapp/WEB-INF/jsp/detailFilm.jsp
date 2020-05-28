<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détail</title>
</head>
<body>

			<h2>${film.getTitre()}</h2>
			<div>
			Réalisateur : ${film.getRealisteur().getNom()}
			Acteurs : 
			Cathégorie : ${film.getCategorie().getLibelle()}
			Année : ${film.getAnnee()}
			</div>
			
			<a href="">Avis</a>
			
</body>
</html>