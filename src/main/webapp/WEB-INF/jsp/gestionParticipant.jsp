<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Gestion des participants</h1>



<a href="<%=request.getServletContext().getContextPath()%>/app/ajouterParticipant">Ajouter un participant</a> 
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
<table>
<tr>
<th>Nom</th>
<th>Prénom</th>
<th>Date de naissance</th>
<th>Date de mort</th>
<th>Actions</th>

</tr>

<j:forEach items="${participants }" var="p">
<tr>
<td>${p.getNom() }</td>
<td>${p.getPrenom() }</td>
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