<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="payment.web.entity.BankAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard - PaymentWebApp</title>
</head>
<body>
<center>
<div class = "navbar">
<h3>WELCOME TO</h3>
<h1>PAYMENT WEB APP</h1>

<form action="http://localhost:8080/PaymentWabApp/LogoutServlet">
<input type="Submit" value="LOG OUT" align="right"/>
</form>
</div>

<div class="header">
	<% 
	
	String UserName = (String)session.getAttribute("name"); %>
	<h2>Welcome <%=UserName %> ;</h2>
</div>
<div class="BankAcctList"> 
	<h1>BANK ACCOUNT LIST</h1><br>
	<% List<BankAccount> balist = (List<BankAccount>)session.getAttribute("Balist"); 
		if(balist != null){
		for(int i= 0;i<balist.size();i++){ 
			BankAccount ba = balist.get(i);%>
		<hr>
		<h2>BankAcount No : <%=ba.getBankAcctName()%></h2>
		<h2>BankAcount Name : <%=ba.getBankAcctName()%></h2>
		<h2>BankAcount IfscCode : <%=ba.getBankIFSCCode()%></h2>
		<h2>Current Bank Balance : <%=ba.getCurrBankBal()%></h2>
		<%} %>
		<%} %>
		<form action="http://localhost:8080/PaymentWebApp/AddBankAcct.jsp">
		<input type="submit" value="Add Bank Account" >
		</form>
</div>
</center>
</body>
</html>