<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Jsp Novamente</h1>
	
	<form action="LoginServilet" method="post">
	
		<table>
			<tr>
				<td><label>Usuário:</label></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
		
	</form>
	<h4>${ msg }</h4>
</body>
</html>