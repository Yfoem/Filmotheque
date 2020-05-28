<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/accueil.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body>
<h2><a class="noLink" href="<%=request.getContextPath()%>">ENI-Filmothèque</a></h2>
<div style="float:right;margin-right:100px">
<h4><a href="<%=request.getContextPath()%>/app/film">Films</a></h4>
<h4><a href="<%=request.getContextPath()%>/app/categorie">Catégories</a></h4>
<h4><a href="<%=request.getContextPath()%>/app/gestionParticipant">Participants</a></h4>
</div>

<h1 class="text-center" style="margin-top:100px">Gestion des participants</h1>

<p>${erreur }</p>


<%
                    if(request.getAttribute("participant")== null){
                        %>
 
<h3>Ajouter un participant</h3>
<form method="post" action="<%=request.getServletContext().getContextPath()%>/app/ajouterParticipant">

<label>Nom:</label><input type="text" name="nom"> 
<label>Prénom:</label><input type="text" name="prenom"> 
<label>Date de naissance:</label><input type="date"   name="naissance"> 
<label>Date de mort:</label><input type="date" name="mort"> 
<input type="submit" value="Ajouter"> 

</form>
 
<%}
else {
%>
 
<h3>Modification  </h3>
<form method="post" action="<%=request.getServletContext().getContextPath() %>/app/modifierParticipant?id=${participant.getId() }">

<label>Nom: </label><input type="text" name="nom" value="${participant.getNom()}">
<label>Prénom:</label><input type="text" name="prenom" value="${participant.getPrenom()}">
<label>Date de naissance:</label><input type="date" name="naissance" value="${participant.getDateDeNaissance()}">
<label>Date de mort:</label><input type="date" name="mort" value="${participant.getDateDeMort()}">
<input type="submit" value="Enregistrer">
</form>
 
<%
}
%>
<br>
<table class="table table-dark">
<tr>
<th>Nom</th>
<th>Prénom</th>
<th>Date de naissance</th>
<th>Date de mort</th>
<th>Actions</th>

</tr>

<j:forEach items="${participants }" var="p">
<tr>
<td class="text-uppercase">${p.getNom() }</td>
<td class="text-capitalize">${p.getPrenom() }</td>
<td>${p.getDateDeNaissance() }</td>
<td>${p.getDateDeMort() }</td>
<td>
<a href="<%=request.getServletContext().getContextPath()%>/app/modifierParticipant?id=${p.getId()}">Modifier</a>
<a href="<%=request.getServletContext().getContextPath()%>/app/supprimerParticipant?id=${p.getId()}">Supprimer</a>
</td>
</tr>
</j:forEach>

</table>

</body>
</html>