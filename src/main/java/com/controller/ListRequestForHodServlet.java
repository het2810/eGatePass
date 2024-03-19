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

@WebServlet("/ListRequestForHodServlet")
public class ListRequestForHodServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer accept = Integer.parseInt(request.getParameter("accept"));
		Integer waiting = Integer.parseInt(request.getParameter("waiting"));
		Integer reject = Integer.parseInt(request.getParameter("reject"));
		Integer hod = Integer.parseInt(request.getParameter("hod"));
		Integer security = Integer.parseInt(request.getParameter("security"));
		
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>();
		if(accept == 0 && waiting ==0 && reject ==0) {
			requests = RequestDao.getParticularStudent();
		}
		else if(accept == 1 && waiting ==0 && reject ==0) {
			requests = RequestDao.getParticularStudentAccepted();
		}
		else if(accept == 0 && waiting ==1 && reject ==0) {
			requests = RequestDao.getParticularStudentWaiting();
		}
		else if(accept == 0 && waiting ==0 && reject ==1) {
			requests = RequestDao.getParticularStudentRejected();
		}
		
		request.setAttribute("requests", requests);
		request.setAttribute("hod",hod);
		request.setAttribute("security", security);
		request.setAttribute("accept", accept);
		request.setAttribute("reject", reject);
		request.setAttribute("waiting", waiting);
		RequestDispatcher rd = request.getRequestDispatcher("requestListForHodAndSecurity.jsp");
		rd.forward(request, response);
	}
}
