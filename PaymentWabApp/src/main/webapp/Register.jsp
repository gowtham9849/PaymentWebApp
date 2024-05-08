<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<center>

	<h1>Register</h1>
	<form action="http://localhost:8080/PaymentWabApp/RegisterServlet" method="post"> 
	<label>First Name : </label><input type="text" name="fname"><br>
	<br>
	<label>Last Name : </label><input type="text" name="lname"><br>
	<br>
	<label>Phone No : </label><input type="text" name="phno"><br>
	<br>
	<label>Email Id : </label><input type="text" name="email"><br>
	<br>
	<label>Date Of Birth : </label><input type="date" name="dob"><br>
	<br>
	<label>Address : </label><input type="text" name="address"><br>
	<br>
	<label>Password : </label><input type="text" name="password"><br>
	<br>
	<label>Confirm Password : </label><input type="text" name="Confirm"><br>
	
	<input type="submit">
	</form>
</center>
</body>
</html>