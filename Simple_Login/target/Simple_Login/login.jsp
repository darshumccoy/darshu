<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>employee details are <span>${msg}</span></h1>
	<form action="login.do" method="post">
		Id:<input type="text" name="id" /><br> password:<input
			type="text" name="pass"><br> <input type="submit" value="login">

	</form>
	<h4>${error}</h4>
</body>
</html>