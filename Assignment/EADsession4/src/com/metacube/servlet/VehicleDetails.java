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
import com.metacube.pojo.VehicleDetailsPojo;

/**
 * Servlet implementation class VehicleDetails
 */
@WebServlet("/VehicleDetails")
public class VehicleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String vehicle_name = request.getParameter("vehiclename");
		String select_type = request.getParameter("selectType");
		String vehicle_number = request.getParameter("vehiclenumber");
		int employe_Id = Integer.parseInt(request.getParameter("employeId"));
		String identification = request.getParameter("identification");
		//String currency = request.getParameter("currency");
		//String plan = request.getParameter("plan");
	//	String selectType = request.getParameter("selectType");
		DataOperations dataOperations = new DataOperations();
		response.setContentType("text/html");

		VehicleDetailsPojo  vehicleDetailsData = new VehicleDetailsPojo(employe_Id, vehicle_name, select_type, vehicle_number, identification);
		HttpSession session = request.getSession();
		
		int a = dataOperations.vehicleDetail(vehicleDetailsData);
		session.setAttribute("vtype", select_type);
		session.setAttribute("vnumber", vehicle_number);
		
		if (a == 1) {
			
			response.sendRedirect("ChoosePlan.jsp");
			
	        
		} else {
			out.print("Vehicle Data Not Added");
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
