package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.service.EmailService;


public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int password = Integer.parseInt(request.getParameter("password"));
		int mobile = Integer.parseInt(request.getParameter("mobile"));
//		UserDao userDao = new UserDao();
//		boolean result = userDao.findEmail(email);
//		Cookie newc = new Cookie("email",email);
//		response.addCookie(newc);
		
		int enrollment = -1,userId=-1;
		Cookie allCookies[] = request.getCookies();
		for(int i=0;i<allCookies.length;i++){
			if(allCookies[i].getName().equals("enrollment")){
				enrollment = Integer.parseInt(allCookies[i].getValue());
			}
			if(allCookies[i].getName().equals("userId")){
				userId = Integer.parseInt(allCookies[i].getValue());
			}
		}
		
		{
			int otp = (int)(Math.random() * 100000);
			UserDao.setOtp(userId,otp);
			System.out.println("Pohochhaa");
			EmailService emailService = new EmailService();
			emailService.sendOtpForForgetPassword(email, otp);
			if(password == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("change_pass.jsp");
				rd.forward(request, response);
			}
			else if(mobile == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("change_mobile.jsp");
				rd.forward(request, response);
			}
		}
	}

}
