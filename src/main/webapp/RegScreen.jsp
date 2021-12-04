<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.*" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat"%> 
<%
	/* Accessing the database
	String id = request.getParameter("userid");
	String driver = "org.postgresql.Driver";
	String connectionUrl = "jdbc:postgresql://localhost:5432/cpp_restaurant";
	String userid = "postgres";
	String password = "123";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Screen</title>
</head>
<body>
	<div align="center">
	<!-- Grabbing items from database and loading the customer's screen with available items & prices -->
		<form action="PaymentScreen.jsp" method="post">
			<table>
				<tbody>
					<tr>
					<% /*
					try {
						connection = DriverManager.getConnection(driver, userid, password);
						statement = connection.createStatement();
						String sql = "SELECT name FROM fooditem";
						rs = statement.executeQuery(sql);
						while(rs.next()){
						*/
					%>
					<!-- 
						<td>Item</td>
						<td>
							<select name="item">
								<option><%//=rs.getString("name") %></option>
							</select>
						</td>
						<td>Price</td>
						<td><input type="text" name="price" value="" size="50" /></td>
						<td>Quantity</td>
						<td><input type="text" name="quantity" value="" size="50" /></td>
						<td><input type="button" value="Add"></td>
					</tr>
					-->
					<% /*
					}
					connection.close();
					} catch (Exception e) {
					e.printStackTrace();
					}
					*/
					%>
					<tr>
						<td>Item</td>
						<td>
							<select name="item">
								<option>Sandwich</option>
								<option>Water</option>
							</select>
						</td>
						<td> Price</td>
						<td><input type="text" name="price" value="" size="50"/> </td>
						<td>Quantity</td>
						<td><input type="text" name="quantity" value="" size="50"/> </td>
						<td><input type="button" value="Add" name="Add"></td>
					</tr>
				</tbody>
			</table>
			<!-- Table for customer to be able to add new items into their order -->
			<table border="1">
				<thead>
					<tr>
						<td>Item</td>
						<td>Price</td>
						<td>Quantity</td>
						<td>Total Price</td>
					</tr>
				</thead>

				<tbody>
					<tr>
					</tr>
				</tbody>
				
			</table>
			<!-- Buttons to move onto the payment screen or reset the entire form.  -->
			<input type="submit" value="Order" name="order"/>
			<input type=reset value="Clear" name="cancel"/>
		</form>
	</div>

	
</body>
</html>
