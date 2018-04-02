<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create</title>
</head>
<body>
	<form action="create.do" method="post" >

		Id:<input type="text" name="id"><br> 
		 name:<input type="text" name="name"><br> 
		  email:<input type="text" name="email"><br> <form:errors path="email" />
		   password:<input type="text" name="pass"><br><form:errors path="pass" />
		    <input type="submit" value="create">

	</form>
	
	<a href="login.jsp">Login page</a>
</body>
</html>