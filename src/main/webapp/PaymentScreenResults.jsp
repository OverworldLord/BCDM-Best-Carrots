<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Information</title>
</head>
<%
	// Getting the customers input from payment screen
	String firstName = request.getParameter("first");
	String lastName = request.getParameter("last");
	String fullName = firstName + " " + lastName;
	String paymentMethod = request.getParameter("paymentMethod");
	String cardNumber = request.getParameter("cardNumber");
	String expDate = request.getParameter("expDate");
	String ccv = request.getParameter("ccv");
	String customerType = request.getParameter("customerType");
	
	// Setting up the format for date and time
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String stringDate = formatter.format(date);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();
	String time = dtf.format(now);
%>

<body>
	<!-- Table displaying the information of customer's order -->
	<h2>Order Information</h2>
	<table border="1">
		<tbody>
			<tr>
				<th>Item</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<tr>
				<td>Sandwich</td>
				<td>1</td>
				<td>4.99</td>
			</tr>
			<tr>
				<td>Water</td>
				<td>1</td>
				<td>1.99</td>
			</tr>
		</tbody>
	</table>
	<!-- Table displaying information from customers payment screen -->
	<h2>Payment Information</h2>
	<table border="1">
		<tbody>
			<tr>
				<td>Payment Method:</td>
				<td><%=paymentMethod %></td>
			</tr>
			<tr>
				<td>Card Number:</td>
				<td><%=cardNumber%></td>
			</tr>
			<tr>
				<td>Customer:</td>
				<td><%=fullName %></td>
			</tr>
			<tr>
				<td>Customer Type:</td>
				<td><%=customerType %></td>
			</tr>
			<tr>
				<td>Transaction date:</td>
				<td><%=stringDate %></td>
			</tr>
			<tr>
				<td>Transaction time:</td>
				<td><%=time %>
			</tr>				
		</tbody>
	</table>
	<td> 
		<select name="counterStatus">
			<option>Counter</option>
			<option>Online-Pending</option>
			<option>Online-Complete</option>
		</select>
	<input type="button" value="Delete" id="delete">
	<input type="button" value="Back" id="back">
	<input type="button" value="Update" id="Update">
</body>
</html>