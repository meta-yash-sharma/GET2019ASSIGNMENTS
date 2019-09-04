package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.DataOperations;

/**
 * Servlet implementation class ParkingPlan
 */
@WebServlet("/ParkingPlan")
public class ParkingPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		
		 
		HttpSession session = request.getSession();
		
		String passType = request.getParameter("passtype");
		
		String vehicleType=(String) session.getAttribute("vtype");
		
		String vehicleNumber=(String) session.getAttribute("vnumber");
		
		int empId=Integer.parseInt(session.getAttribute("empId").toString());
		
	    float daily = (float) (5/71.4);
	    float monthly = (float) (100/71.4);
	    float yearly = (float) (500/71.4);

	    if ( "Motocycle".equals(vehicleType)) {
	        daily = (float) (10/71.4);
	        monthly = (float) (200/71.4);
	        yearly = (float) (1000/71.4);
	    } else if ( "Car".equals(vehicleType)) {
	        daily = (float) (20/71.4);
	        monthly = (float) (500/71.4);
	        yearly = (float) (3500/71.4);
	    }
	    
	    float price = daily;
	    
	    if("monthly".equals(passType)){
	    	price= monthly;
	    }else if("yearly".equals(passType)){
	    	price= yearly;
	    }

		int a = DataOperations.insertIntoPlan(empId,vehicleNumber,passType,price);
		
		//out.print(Variables.upperBody);
		if(a == 1){
			out.println("<p style='font-size:140%'>Plan choosen successfully ,  please <a href='homepage.jsp'>click here </a> to go to homepage</p>");
		}else {
			out.println("<p style='font-size:140%'>Plan Not choosen successfully ,  please <a href='homepage.jsp'>click here </a> to go to homepage</p>");
		}
		
		//out.print(Variables.lowerBody);
		
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
