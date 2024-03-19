package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RequestDao;

public class SecurityDashBoardServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Security DashBoard Service");
		
		RequestDao req= new RequestDao();
		int totalRequest = req.getAllRequests().size();
		int acceptedRequest = req.getSpecificRequest(1).size();
		
		request.setAttribute("totalRequest", totalRequest);
		request.setAttribute("acceptedRequest", acceptedRequest);
		RequestDispatcher rd = request.getRequestDispatcher("DashBoardSecurity.jsp");
		rd.forward(request, response);
	}

}
