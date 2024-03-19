package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.RequestDao;
import com.dao.UserDao;
import com.service.EmailService;

@WebServlet("/ChangeRequestStatus")
public class ChangeRequestStatusServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer requestId = Integer.parseInt(request.getParameter("requestId"));
		int userId=0;
		Cookie c[] = request.getCookies();
		for (Cookie x : c) {
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}
		UserBean user = new UserBean();
		UserDao userDao = new UserDao();
		user = userDao.getDetailsForRequest(userId);
		RequestDao.changeRequestStatus(requestId);
		EmailService emailService = new EmailService();
		System.out.println(user.getEmail());
		emailService.sendResponse(user.getEmail());
		response.sendRedirect("ListRequestServlet?security=0");
	}
}
