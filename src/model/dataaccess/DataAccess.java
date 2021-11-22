package model.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataAccess {
	
	private static String rsQuery(PreparedStatement stmt) throws SQLException {
		
		ResultSet rs = stmt.executeQuery();
		
		ResultSetMetaData rsData = rs.getMetaData();
		
		final int columnCount = rsData.getColumnCount();
	
		String output = "";
		
		while(rs.next()) {
		
			
			for(int i = 1; i <= columnCount; i++) {
				
				output += rs.getString(i) + " ";
			}
			
			output += "\n";
		}
		
		return output;
		
	}
	
	public static String Test(String dbName) throws ClassNotFoundException, SQLException {
		
		Connection connection = new ConnectionFactory().DBConnection();
		
		final PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + dbName);
		
		return DataAccess.rsQuery(stmt);
		
	}
	
	// Retrieve a row of data from a table in our database
	// @param table = name of table
	// @param where = specific data to identify row
	
	public static String getInDBWhere(String table, String where) throws ClassNotFoundException, SQLException {
		
		Connection connection = new ConnectionFactory().DBConnection();
		
		final PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + where);
		
		return DataAccess.rsQuery(stmt);
		
	}
	
	public static void insertIntoDBValues(String dbName, String values) throws ClassNotFoundException, SQLException {
		Connection connection = new ConnectionFactory().DBConnection();
		
		final PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + dbName + " VALUES " + values);
				
		stmt.executeUpdate();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println(DataAccess.getInDBWhere("customer", "\"broncoID\"=145"));

	}

}
