package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;
import com.metacube.pojo.Employee;

/**
 * Servlet implementation class FriendList
 */
@WebServlet("/FriendList")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		
		if(request.getParameter("emailid") != null){
			
			//int empId = 
			
			Employee emp = DataOperations.empDetailsWithEmail((String)request.getParameter("emailid"));
			
			
			request.setAttribute("fullName", emp.getFullName());
			request.setAttribute("email", emp.getEmail());
			request.setAttribute("contact_number", emp.getContactNumber());
			RequestDispatcher rd = request.getRequestDispatcher("/FriendProfile.jsp");  
	        rd.forward(request, response);
			
		}
		else {
			
			int empId = Integer.parseInt(session.getAttribute("empId").toString());
			String organizationName = null;
			ResultSet rs = DataOperations.showEmployee(empId);
			
			try {
				
				rs.next();
				 organizationName = rs.getString(7);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			List<Employee> friend = DataOperations.showFriendList(empId, organizationName);
			
			for(int i =0; i < friend.size(); i++){
				
				out.print("<table><tr><td>"					
						+ friend.get(i).fullName+ "</td>"
						+ "<td> <a href='http://localhost:8080/EADsession4/FriendList?emailid="+ friend.get(i).getEmail()
						+ "'>View profile</a></td>");
				
				//out.print();
				
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
