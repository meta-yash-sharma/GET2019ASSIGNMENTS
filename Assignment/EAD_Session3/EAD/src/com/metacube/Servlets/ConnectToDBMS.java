package com.metacube.Servlets;

import java.sql.*;

public class ConnectToDBMS {
	
	public Connection createConnectionObj(){
		try {
			Data data = new Data();
			// ----------------------------------------------------------------------------------------------------
			// CREATING Connection to DATABASE.

			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//Open a connection
			Connection connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_data",
					"root", "admin");
			
			return connObj;
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;			
	}
}
