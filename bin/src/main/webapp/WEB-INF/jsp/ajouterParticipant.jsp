<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Ajouter un participant</h3>
<form method="post" action="<%=request.getServletContext().getContextPath()%>/app/ajouterParticipant">

<label>Nom:</label><input type="text" name="nom"> 
<label>Prénom:</label><input type="text" name="prenom"> 
<label>Date de naissance:</label><input type="date"   name="naissance"> 
<label>Date de mort:</label><input type="date" name="mort"> 
<input type="submit" value="Ajouter"> 

</form>
</body>

 
</html>