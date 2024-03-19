package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RequestBean;
import com.dao.RequestDao;

@WebServlet("/ListParticularStudentServlet")
public class ListParticularStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enrollment = request.getParameter("enrollment");
		int accept = Integer.parseInt(request.getParameter("accept"));
		int waiting = Integer.parseInt(request.getParameter("waiting"));
		int reject = Integer.parseInt(request.getParameter("reject"));
		
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		if(accept == 0 && waiting ==0 && reject ==0) {
			requests = RequestDao.getParticularStudent(Integer.parseInt(enrollment));
		}
		else if(accept == 1 && waiting ==0 && reject ==0) {
			requests = RequestDao.getParticularStudentAccepted(Integer.parseInt(enrollment));
		}
		else if(accept == 0 && waiting ==1 && reject ==0) {
			requests = RequestDao.getParticularStudentWaiting(Integer.parseInt(enrollment));
		}
		else if(accept == 0 && waiting ==0 && reject ==1) {
			requests = RequestDao.getParticularStudentRejected(Integer.parseInt(enrollment));
		}
		
		request.setAttribute("requests", requests);
		RequestDispatcher rd = request.getRequestDispatcher("listRequest.jsp");
		rd.forward(request, response);
	}
}
