<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%
	//Getting the customer's input from Reg Screen
	String name = request.getParameter("item");
	String price = request.getParameter("price");
	int itemID = 0;
	Statement statement = null;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	
	String stringDate = formatter.format(date);
	
	// Accessing database and adding items to order
	try	{
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cpp_restaurant", "postgres", "123");
		try {
			ResultSet rs = statement.executeQuery("SELECT MAX(\"itemID\") FROM fooditem");
			if(rs.next()) {
			itemID = 1  + rs.getInt(1);
			}
		} finally {
			
		}
		Statement st = conn.createStatement();
		int i = st.executeUpdate("SELECT * FROM fooditem");
	}
	catch(Exception e) {
		System.out.print(e);
		e.printStackTrace();
	} finally {
		
	}
%>