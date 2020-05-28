<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	
	<h1>Connexion</h1>
	<div>		
		<p style="color:red">${error}</p>
		<form action="<%=request.getServletContext().getContextPath() %>/app/login" method="POST" >
			<div>
				<label for="identifiant">Identifiant : </label>
				<input type="text" id="identifiant" name="identifiant" value="" />
			</div>
			<div>
				<label for="motDePasse">Mot de passe : </label>
				<input type="password" id="motDePasse" name="motDePasse" value=""/>
			</div>
			
			<button type="submit">Se connecter</button>
		</form>
	
	</div>
</body>
</html>