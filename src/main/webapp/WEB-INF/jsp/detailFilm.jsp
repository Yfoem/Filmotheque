<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D�tail</title>
</head>
<body>

			<h2>${film.getTitre()}</h2>
			<div>
			R�alisateur : ${film.getRealisteur().getNom()}
			Acteurs : 
			Cath�gorie : ${film.getCategorie().getLibelle()}
			Ann�e : ${film.getAnnee()}
			</div>
			
			<a href="">Avis</a>
			
</body>
</html>