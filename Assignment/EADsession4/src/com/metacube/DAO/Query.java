package com.metacube.DAO;

public class Query {

	public static String employeeInsert() {
		
	return "INSERT INTO employee_details(fullname,gender,email,password,contact_number,organization) VALUES(?,?,?,?,?,?)";
 }
	
	public static String login(String email,String password) {
		return " SELECT email,password,employee_id FROM employee_details "
				+ "WHERE email = '" + email + "' AND password = '" + password + "' ";
	}

	public static String vehicle() {
		
		return "INSERT INTO vehicle_details(vehicle_name,type,vechile_number,employee_id,identification) VALUES(?,?,?,?,?)";
	}
	
	public static String SecondTimelogin(String email) {
		return " SELECT v.employee_id FROM employee_details e,vehicle_details v "
				+ "WHERE e.email = '" + email + "' AND e.employee_id = v.employee_id ";
	}
	
	public static String showEmployee(int id) {
		return " SELECT * FROM employee_details WHERE employee_id = " +id;
	}
	
	public static String UpdateEmployeeData(int id, String fullname, String password, long contact_number) {

		return "UPDATE employee_details " + " SET fullname = '" + fullname + "', "
				 + "password = '" + password + "', " + "contact_number = " + contact_number
				 + " WHERE employee_id = " + id;
		
	}
	
	public static String friendList(int empId, String organizationName){
		
		return "SELECT * FROM employee_details WHERE organization = '"+ organizationName +"'  AND employee_id NOT IN (SELECT employee_id FROM employee_details WHERE employee_id = "+ empId +" )";
		
	}
	
	
	public static String empDetailsWithEmail(String email){
		
		return "SELECT * FROM employee_details WHERE email = '"+ email +"'";
		
	}
	
	public static String insertIntoPlan(){
		return "INSERT INTO plan_details(employee_id, vechile_number, plan, price) VALUES(?,?,?,?)";
	}
}
