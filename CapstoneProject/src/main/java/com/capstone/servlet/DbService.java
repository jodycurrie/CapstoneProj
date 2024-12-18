package com.capstone.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public class DbService {

		private static final String DB_URL = "jdbc:mysql://localhost:3306/fittrack";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "admin";
		

		//connection method
			public static Connection getConnection() throws SQLException, ClassNotFoundException {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
			}
			
			
			//add record
			public static boolean AddUser(String user) {
				
				String query = "INSERT INTO user (userName) VALUES (?)";
				
				
				try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
					
					stmt.setString(1,user );
					
					int RowsAffected = stmt.executeUpdate();
					
					return RowsAffected > 0;
					
				} catch (SQLException | ClassNotFoundException e) {
					
					e.printStackTrace();
					return false;
					
				}
				
				
			}
	

}
