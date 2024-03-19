package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

/**
 * Servlet implementation class AdminDashboardServlet
 */
public class AdminDashboardServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin Servlet Service");
		
		// get total student list , hod list , security list etc , particular student list
		
		
		
		UserDao userDao = new UserDao();
		int totalStudents = userDao.getTotalUsersByRole(4); // students
		int totalHod = userDao.getTotalUsersByRole(2); // hod
		int totalSecurity = userDao.getTotalUsersByRole(3); // security
		
		request.setAttribute("totalStudents", totalStudents);
		request.setAttribute("totalHod", totalHod);
		request.setAttribute("totalSecurity", totalSecurity);
		
		RequestDispatcher rd = request.getRequestDispatcher("DashBoardAdmin.jsp");
		rd.forward(request, response);
	}

}
