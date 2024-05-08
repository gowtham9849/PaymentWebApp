<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bank Acct</title>
</head>
<body>
	<center>
	<form action="http://localhost:8080/PaymentWabApp/AddBankAcctServlet"  method="post">
	<h1>Bank Account Deitails</h1>
	<label>BankAcctNo : </label><input type="text" name="bankno"><br>
	<label>BankAcctName : </label><input type="text" name="bankname"><br>
	<label>BankAcctTypeId : </label><input type="text" name="accttypeid"><br>
	<label>BankIFSCCode: </label><input type="text" name="bankifsc"><br>
	<label>Bankpin : </label><input type="text" name="bankpin"><br>
	<input type="Submit">
	</form>
	</center>
</body>
</html>