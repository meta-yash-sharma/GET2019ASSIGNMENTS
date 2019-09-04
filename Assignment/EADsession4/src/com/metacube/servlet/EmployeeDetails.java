package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.DAO.DataOperations;
import com.metacube.pojo.Employee;

//import com.metacube.servlets.StatementOfSQL;

/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String full_name = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long contact_number = Long.parseLong(request.getParameter("contactnumber"));
		String organization = request.getParameter("selectOrganization");
		
		//DataOperations dataOperations = new DataOperations();
		response.setContentType("text/html");
		
		Employee emp = new Employee(full_name, gender, email, password, contact_number, organization);
		
		int a = DataOperations.insertEmployeeDetail(emp);

		if (a == 1) {
			
			out.print(" Data Successfully Added");
			out.print("<br><br>");
			out.print("Click here to ");
			out.print("<a href = 'index.html'>login</a>");
		} else {
			out.print("Student Data Not Added");
			out.print("<br><br>");
			out.print("Email Id already exist");
		}

	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
