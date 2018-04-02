
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit page</title>
</head>
<body>
<h2>edit form</h2>
<form action="edit2.do" method="post">

<h3>Edit Ur details with Id: ${id}</h3>

		id:<input type="text" value="${id }	" name="id" />	
		Name:<input type="text" value="${name}" name="name" /><br>
		email:<input type="text" value="${email}" name="email" /><br>
		 password:<input type="text" value="${pass}" name="pass"><br>
		  <input type="submit" value="SUBMIT">

	</form>


</body>
</html>