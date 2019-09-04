package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html");
		try {
           
			HttpSession session = request.getSession();
			int empId =   Integer.parseInt(session.getAttribute("empId").toString());
			ResultSet rs = DataOperations.showEmployee(empId);
			rs.next();
			String fullName = rs.getString(2);
			String gender = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			long contact_number = rs.getLong(6);
			String organization = rs.getString(7);
			
		//	out.print(fullName);
			
			request.setAttribute("fullName", fullName);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("contact_number", String.valueOf(contact_number));
			RequestDispatcher rd=request.getRequestDispatcher("/EditEmployeeData.jsp");  
	        rd.forward(request, response);
	
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
