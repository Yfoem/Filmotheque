<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/accueil.css">
</head>
<body>

<h1 class="text-center">Détail du film ${film.getTitre()}</h1>
<div class="mx-auto" style="border:solid;width:400px;margin-top:80px" >
			Titre : ${film.getTitre()}<br>
			
			Réalisateur : ${film.getRealisteur().getNom()} ${film.getRealisteur().getPrenom()}<br> 
			Catégorie : ${film.getCategorie().getLibelle()}<br>
			Date de sortie: ${film.getAnnee()}
			<div class="mx-auto" style="width:100px;margin-top:40px">
			<a href="<%=request.getServletContext().getContextPath() %>/app/retour"><button>Retour</button></a>
			</div>
			
	
	
</div>
		
			
			
</body>
</html>