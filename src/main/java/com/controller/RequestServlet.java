package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
import com.service.EmailService;

@WebServlet("/RequestServlet")       // web.xml mai link krna nahi pade isliye
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String today = df.format(d);
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
		UserBean user = UserDao.getDetailsForRequest(enrollmentNumber);
		String reason = request.getParameter("reason");
		String askTime = request.getParameter("askTime");
		System.out.println(reason);
		System.out.println("Service method of request servlet hit!");
		
		RequestBean req = new RequestBean();
		req.setName(user.getFirstName()+" "+user.getLastName());
		req.setEnrollmentNumber(enrollmentNumber);
		req.setReason(reason);
		req.setLeavesLeft(user.getLeaves());
		req.setAskTime(askTime);
		req.setPassDate(today);
		
		UserDao userDao = new UserDao();
		UserBean user1 = new UserBean();
		user1 = userDao.getDetailsForRequest(enrollmentNumber);
		EmailService emailService = new EmailService();
//		UserDao.setLeaves((Integer.parseInt(f_leaves) - 1),Integer.parseInt(enrollment));
		
		int result = RequestDao.addRequest(req);
//		req = new RequestBean();
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>(); // for sending request on mail and accepting it using it
		requests = RequestDao.getParticularStudent(enrollmentNumber);
		emailService.sendRequestForVerification(user1.getEmail(), requests.get(0).getName(), requests.get(0).getEnrollmentNumber(), requests.get(0).getReason(),requests.get(0).getRequestId(),requests.get(0).getApprove());
		if(result == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("StudentDashboardServlet");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}
}
