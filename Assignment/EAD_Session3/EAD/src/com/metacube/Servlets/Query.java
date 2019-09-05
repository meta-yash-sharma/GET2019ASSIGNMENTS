package com.metacube.Servlets;

public class Query {
	
	public String insertStudentData() {		
		return "INSERT INTO StudentData(first_name,last_name, father_name,email,class,age) VALUES "
				+ "(?,?,?,?,?,?)";		
	}
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 0
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_0(){
		return "SET FOREIGN_KEY_CHECKS = 0 ";
	}
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 1
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_1(){
		return "SET FOREIGN_KEY_CHECKS = 1 ";
	}
	
	
	public String StudentTableData(){
		return "SELECT * "
				+"FROM StudentData ";
	}
	
	public String queryForSearchByName() {
		return "SELECT * FROM StudentData WHERE first_name = ? AND last_name = ? ";
	}
	
	public String queryForSearchByClass() {
		return "SELECT * FROM StudentData WHERE class = ? ";
	}
	
	
	public static String studentdata(int id){
		return "SELECT * FROM StudentData where student_id = "+id;
	}
	
	public static String UpdateStudentData(int id, String firstname, String lastname, String fathername, String Semail, int class_no, int Sage){

	return "UPDATE StudentData "
	+ "SET first_name = '"+firstname+"', "
	+ "last_name = '"+lastname+"', "
	+ "father_name = '"+fathername+"', "
	+ "email = '"+Semail+"', "
	+ "class = "+class_no+", "
	+ "age = "+Sage+" "
	+ " WHERE student_id = "+id;	
	}
}
