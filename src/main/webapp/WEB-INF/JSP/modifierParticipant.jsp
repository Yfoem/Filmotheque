<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Modification  </h3>
<form method="post" action="<%=request.getServletContext().getContextPath() %>/app/modifierParticipant?id=${participant.getId() }">
<%-- <input type="text" name="id" value="${participant.getId() }" hidden> --%>
<label>Nom: </label><input type="text" name="nom" value="${participant.getNom()}">
<label>Prénom:</label><input type="text" name="prenom" value="${participant.getPrenom()}">
<label>Date de naissance:</label><input type="date" name="naissance" value="${participant.getDateDeNaissance()}">
<label>Date de mort:</label><input type="date" name="mort" value="${participant.getDateDeMort()}">
<input type="submit" value="Enregistrer">
</form>


</body>
</html>