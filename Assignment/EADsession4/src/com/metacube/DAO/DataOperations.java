package com.metacube.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.pojo.Employee;
import com.metacube.pojo.VehicleDetailsPojo;

//import com.metacube.servlets.ConnectionToDbms;
//import com.metacube.servlets.Query;


public class DataOperations {

	public static ConnectionToDbms obj = new ConnectionToDbms();
	public static Connection connObj = obj.connectionObject();
	
	public static int insertEmployeeDetail(Employee emp) {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();

			PreparedStatement pstmt = connObj.prepareStatement(query.employeeInsert());
			pstmt.setString(1, emp.getFullName());
			pstmt.setString(2, emp.getGender());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPassword());
			pstmt.setLong(5, emp.getContactNumber());
			pstmt.setString(6, emp.getOrganization());

			a = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return a;
	}
	
	public static int loginCheck(String email,String password) {
		 int empId = Integer.MIN_VALUE;;
		try {

			Statement stmt = connObj.createStatement();
			ResultSet rs = stmt.executeQuery(Query.login(email, password));
			
			rs.next();
			
			if(rs.getString(1) != null){
				empId = rs.getInt(3);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return empId;
	}
	
	public static boolean SecondTimeloginCheck(String email) {
		ResultSet rs = null;
		try {

			
			Statement stmt = connObj.createStatement();

		
			rs = stmt.executeQuery(Query.SecondTimelogin(email));
			
			if(rs.next())	
			{
				return false;
			} else {
				return true;
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return false;
	}
	
	public static int vehicleDetail(VehicleDetailsPojo data) {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			

			PreparedStatement pstmt = connObj.prepareStatement(Query.vehicle());
			pstmt.setString(1, data.getVehicleName());
			pstmt.setString(2, data.getVehicleType());
			pstmt.setString(3, data.getVechicleNumber());
			pstmt.setInt(4, data.getEmpId());
			pstmt.setString(5, data.getIdentification());
			

			a = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return a;
	}
	
	public static ResultSet showEmployee(int id) {
		ResultSet rs = null;
		try {
			
			Statement stmt = connObj.createStatement();		
			rs = stmt.executeQuery(Query.showEmployee(id));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int updateEmployee(int id,String fullname, String password, long contact_number) {
		int rs = Integer.MIN_VALUE;
		try {
			
			Statement stmt = connObj.createStatement();	
			rs = stmt.executeUpdate(Query.UpdateEmployeeData(id, fullname, password, contact_number));
			
			
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static List<Employee> showFriendList(int empId, String organizationName) {
		
		List<Employee> friendList = new ArrayList<Employee>();
		
		try {
			
			Statement stmt = connObj.createStatement();		
			ResultSet rs = stmt.executeQuery(Query.friendList(empId, organizationName));
			
			while(rs.next()){
				friendList.add(new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7)));
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return friendList;
	}
	
	public static Employee empDetailsWithEmail(String email){
		Employee emp = null;
		
		try {
			
			Statement stmt = connObj.createStatement();		
			ResultSet rs = stmt.executeQuery(Query.empDetailsWithEmail(email));
			
			rs.next();
			
			emp = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return emp;
		
	}
	
	public static int insertIntoPlan(int empId, String vehicleNumber, String passType, float price){
		
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();

			PreparedStatement pstmt = connObj.prepareStatement(query.insertIntoPlan());
			pstmt.setInt(1, empId);
			pstmt.setString(2, vehicleNumber);
			pstmt.setString(3, passType);
			pstmt.setFloat(4, price);
			a = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return a;
		
	}
}