package model.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	
	// Return result set of requested query
	// @param request: SQL query command
	public static ResultSet queryDB(String request) throws ClassNotFoundException, SQLException {
		
		Connection connection = new ConnectionFactory().DBConnection();
		
		Statement stmt = null;
			
		stmt = connection.createStatement();
			
		ResultSet rs = stmt.executeQuery(request);
		
		return rs;
		
	}

	// Insert values into database
	// @param dbName: name of table to insert values to
	// @param values: list of data to insert specified table
	public static void insertIntoDBValues(String dbName, String values) throws ClassNotFoundException, SQLException {
		Connection connection = new ConnectionFactory().DBConnection();
		
		final PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + dbName + " VALUES " + values);
				
		stmt.executeUpdate();
	}
	

}
