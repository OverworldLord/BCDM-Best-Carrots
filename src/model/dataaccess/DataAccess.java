package model.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	
//	private static String rsQuery(PreparedStatement stmt) throws SQLException {
//		
//		ResultSet rs = stmt.executeQuery();
//		
//		ResultSetMetaData rsData = rs.getMetaData();
//		
//		final int columnCount = rsData.getColumnCount();
//	
//		String output = "";
//		
//		while(rs.next()) {
//		
//			
//			for(int i = 1; i <= columnCount; i++) {
//				
//				output += rs.getString(i) + " ";
//			}
//			
//			output += "\n";
//		}
//		
//		return output;
//		
//	}
//	
	public static ResultSet queryDB(String request) throws ClassNotFoundException, SQLException {
		
		Connection connection = new ConnectionFactory().DBConnection();
		
		Statement stmt = null;
			
		stmt = connection.createStatement();
			
		ResultSet rs = stmt.executeQuery(request);
		
		return rs;
		
	}
//	
//	// Retrieve a row of data from a table in our database
//	// @param table = name of table
//	// @param where = specific data to identify row
//	
//	public static String getInDBWhere(String table, String where) throws ClassNotFoundException, SQLException {
//		
//		Connection connection = new ConnectionFactory().DBConnection();
//		
//		final PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + where);
//		
//		return DataAccess.rsQuery(stmt);
//		
//	}
//	
//	public static String getInDBWhereCol(String col, String table) throws ClassNotFoundException, SQLException {
//		
//		Connection connection = new ConnectionFactory().DBConnection();
//		
//		final PreparedStatement stmt = connection.prepareStatement("SELECT " + col + "FROM " + table);
//		
//		return DataAccess.rsQuery(stmt);
//		
//	}
	
	public static void insertIntoDBValues(String dbName, String values) throws ClassNotFoundException, SQLException {
		Connection connection = new ConnectionFactory().DBConnection();
		
		final PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + dbName + " VALUES " + values);
				
		stmt.executeUpdate();
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//
//		System.out.println(DataAccess.getInDB("student"));
//
//	}

}
