package com.metacube.Servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class StatementOfSQL {

	public static int insertData(String first_name, String last_name, 
			String father_name, String email, int class_no, int age){
		
		int a = Integer.MIN_VALUE;

		try{

			ConnectToDBMS obj = new ConnectToDBMS();

			// CREATING An Statement object.

			Connection connObj = obj.createConnectionObj();

			Statement stmt = connObj.createStatement();

			Query query = new Query();

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_0());

			PreparedStatement pstmt = connObj.prepareStatement(query.insertStudentData());

			pstmt.setString(1, first_name);
			pstmt.setString(2, last_name);
			pstmt.setString(3, father_name);
			pstmt.setString(4, email);
			pstmt.setInt(5, class_no);
			pstmt.setInt(6, age);

			a = pstmt.executeUpdate();

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_1());


			//Statement Object Closed.
			stmt.close();
			pstmt.close();

			//Connection Object Closed.
			connObj.close();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return a;
	}


	public static ResultSet sendStudentTableData(){


		try{

			ConnectToDBMS obj = new ConnectToDBMS();

			// CREATING An Statement object.

			Connection connObj = obj.createConnectionObj();

			Statement stmt = connObj.createStatement();

			Query query = new Query();		

			return stmt.executeQuery(query.StudentTableData());

		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;				
	}
	
	
	public static int updateDetails(int id, String firstname, String lastname, String fathername, String Semail, int class_no, int Sage) {
		int rs = Integer.MIN_VALUE;
		try{

		ConnectToDBMS obj = new ConnectToDBMS();
		Connection connObj = obj.createConnectionObj();
		Statement stmt = connObj.createStatement();

		Query query = new Query();

		//PreparedStatement pstmt = connObj.prepareStatement(query.showStudents);

		rs = stmt.executeUpdate(query.UpdateStudentData(id, firstname, lastname, fathername, Semail, class_no, Sage));


		}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		}
		return rs;
		}

		public static ResultSet studentData(int id){
		ResultSet rs = null;
		try{

		ConnectToDBMS obj = new ConnectToDBMS();
		Connection connObj = obj.createConnectionObj();
		Statement stmt = connObj.createStatement();

		Query query = new Query();

		//PreparedStatement pstmt = connObj.prepareStatement(query.showStudents);

		rs = stmt.executeQuery(query.studentdata(id));


		}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		}
		return rs;
		}
}
