<%@ page language="java"
	contentType="text/html;
	charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Login</title>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
	<h1>Login</h1>
	<form method="POST" action="/myhome/users">
		<input type="hidden" name="a" value="login" />
		<label for="email">email</label>
		<input type="text" name="email" /><br>
		<label for="password">Password</label>
		<input type="password" name="password" /><br/>
		<input type="submit" value="login" />
	</form>
</body>
</html>