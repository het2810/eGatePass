package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RequestDao;

/**
 * Servlet implementation class HodDashboardServlet
 */
public class HodDashboardServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HOD Dashboard service");
		// total request, pending request,rejected request
		
		RequestDao req= new RequestDao();
		int totalRequest = req.getAllRequests().size();
		int acceptedRequest = req.getSpecificRequest(1).size();
		int rejectedRequest = req.getSpecificRequest(2).size();
		int pendingRequest = req.getSpecificRequest(0).size();
		
		request.setAttribute("totalRequest", totalRequest);
		request.setAttribute("acceptedRequest", acceptedRequest);
		request.setAttribute("rejectedRequest", rejectedRequest);
		request.setAttribute("pendingRequest", pendingRequest);
		
		RequestDispatcher rd = request.getRequestDispatcher("DashboardHod.jsp");
		rd.forward(request, response);
	}

}
