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

<j:forEach items="${participant }" var="p">
${p.getNom() }
</j:forEach>
</body>
</html>