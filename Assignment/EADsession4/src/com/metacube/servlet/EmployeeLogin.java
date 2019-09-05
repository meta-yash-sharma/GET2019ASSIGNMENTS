package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;

/**
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String  password = request.getParameter("password");
		
		
		int empId = DataOperations.loginCheck(email, password);
		boolean flag2 = DataOperations.SecondTimeloginCheck(email);
		
		HttpSession session = request.getSession();
		session.setAttribute("empId", String.valueOf(empId));
		session.setAttribute("email", email);
		
		
		if(empId > 0){
			
			if(flag2) {
				//request.setAttribute("empId", String.valueOf(empId));
				response.sendRedirect("VehicleDetails.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("/VehicleDetails.jsp");  
	       // rd.forward(request, response);
			}
			else {
				response.sendRedirect("homepage.jsp");
			//	RequestDispatcher rd=request.getRequestDispatcher("/homepage.jsp");  
		     //   rd.forward(request, response);
			}
			
		}
		else
			out.print("Not login");	
	}

}
