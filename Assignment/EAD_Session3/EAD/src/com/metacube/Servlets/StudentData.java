package com.metacube.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentData
 */
@WebServlet("/StudentData")
public class StudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String first_name = request.getParameter("firstname");
		
		String last_name = request.getParameter("lastname");
		
		String father_name = request.getParameter("fathername");
		
		String email = request.getParameter("email");
		
		int class_no = Integer.parseInt(request.getParameter("class"));
		
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		StatementOfSQL.insertData(first_name, last_name, father_name, email, class_no, age);
		
		out.print("Info of : " + first_name+" "+last_name+" Has been added.");
		

		response.setContentType("text/html");
		out.print("<br><br><h1><a href='index.html'>Visit Home Page.</a></h1>"); 
		
	}

}
