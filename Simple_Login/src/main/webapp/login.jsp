
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Login Page for user ${msg} </h1>


	<form action="login.do" method="post">
		Id:<input type="text" name="id" /><br>
		 password:<input type="text" name="pass"><br>
		  <input type="submit" value="login">

	</form>
	<h5>${error} </h5>
	
</body>
</html>