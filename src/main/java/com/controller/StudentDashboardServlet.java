package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentRequestDao;

@WebServlet("/StudentDashboardServlet")
public class StudentDashboardServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//

		// count-> totalPass , accept,reject,pending
		//
		//
		StudentRequestDao studentRequestDao = new StudentRequestDao();
//		int enrollmentNumber = (Integer) request.getAttribute("enroll");
		Cookie c[] = request.getCookies();
		int userId = -1,enrollmentNumber =-1;
		for (Cookie x : c) {
			if (x.getName().equals("enrollment")) {
				enrollmentNumber = Integer.valueOf(x.getValue());
			}
		}	
		int totalPassRequest = studentRequestDao.getParticularStudent(enrollmentNumber).size();
		int totalAcceptedRequest = studentRequestDao.getRequestByStatus(enrollmentNumber,1).size();
		int totalRejectedRequest = studentRequestDao.getRequestByStatus(enrollmentNumber,2).size();
		int totalPendingRequest = studentRequestDao.getRequestByStatus(enrollmentNumber,0).size();
		
		
		request.setAttribute("totalPassRequest", totalPassRequest);
		request.setAttribute("totalAcceptedRequest", totalAcceptedRequest);
		request.setAttribute("totalRejectedRequest", totalRejectedRequest);
		request.setAttribute("totalPendingRequest", totalPendingRequest);
		request.setAttribute("enrollment", enrollmentNumber);
		
		RequestDispatcher rd = request.getRequestDispatcher("DashboardStudent.jsp");
		rd.forward(request, response);
		
	}

}