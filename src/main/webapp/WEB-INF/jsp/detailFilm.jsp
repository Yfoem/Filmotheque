<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="fr.eni.filmotheque.bo.Membre"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/accueil.css">

<meta charset="UTF-8">


<title>Détail</title>


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

<h1 class="text-center">Détail du film ${film.getTitre()}</h1>
<div class="mx-auto" style="border:solid;width:400px;margin-top:80px" >
			Titre : ${film.getTitre()}<br>
			
			Réalisateur : ${film.getRealisteur().getNom()} ${film.getRealisteur().getPrenom()}<br> 
			Catégorie : ${film.getCategorie().getLibelle()}<br>
			Date de sortie: ${film.getAnnee()}
			
			
	
	
</div>
		
			

</body>
</html>