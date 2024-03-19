package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RequestBean;
import com.bean.UserBean;
import com.dao.RequestDao;
import com.dao.UserDao; 

@WebServlet("/ChangeRequestFromDashboard")
public class ChangeRequestFromDashboardServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// getting enrollment and userId from cookie so that leaves can be modified and changed
		int enrollmentNumber = -1,userId=-1;
		Cookie c[] = request.getCookies();
		for (Cookie x : c) {
			if (x.getName().equals("enrollment")) {
				enrollmentNumber = Integer.parseInt(x.getValue());
			}
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}
		System.out.println(enrollmentNumber);
		System.out.println(userId);
		Integer reqId = Integer.parseInt(request.getParameter("requestId"));
		int accept = Integer.parseInt(request.getParameter("accept"));
		int waiting = Integer.parseInt(request.getParameter("waiting"));
		int reject = Integer.parseInt(request.getParameter("reject"));
		int hod = Integer.parseInt(request.getParameter("hod"));
		int security = Integer.parseInt(request.getParameter("security"));
		
		// for getting leaves left of the particular student
		UserBean user = UserDao.getDetailsForRequest(enrollmentNumber);
		
		// changing status of request
		RequestDao.changeRequestStatus(reqId,Integer.parseInt(request.getParameter("ans")));
		System.out.println("leaves left => " + user.getLeaves());
		if(Integer.parseInt(request.getParameter("ans")) == 1) {
			UserDao.setLeaves(user.getLeaves()-1, enrollmentNumber);
		}
		else if(Integer.parseInt(request.getParameter("ans")) == 2) {
			UserDao.setLeaves(user.getLeaves(), enrollmentNumber);
		}
		
		response.sendRedirect("ListRequestForHodServlet?accept="+accept+"&reject="+reject+"&waiting="+waiting+"&hod="+hod+"&security="+security);
		
	}
}
