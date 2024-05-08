<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<center>
	<h1>Login</h1>

	

		<form action="http://localhost:8080/PaymentWabApp/LoginServlet" method="post">
		<label>Mobile No : </label><input type="text" name="Phno"><br>
		<label>PassWord :</label><input type="text" name="PassWord"><br>
		<input type="submit">
		</form>
		<form>
		<a href="http://localhost:8080/PaymentWebApp/Register.jsp"><h2>REGISTER</h2></a>
		</form>

</center>
</body>
</html>