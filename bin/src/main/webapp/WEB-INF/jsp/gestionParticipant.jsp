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
<table>
<tr>
<th>Nom</th>
<th>Prénom</th>
<th>Date de naissance</th>
<th>Date de mort</th>
<th>Actions</th>

</tr>

<j:forEach items="${participant }" var="p">
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