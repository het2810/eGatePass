package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service of Change Password servlet");
		String password = request.getParameter("password");
		int otp = Integer.parseInt(request.getParameter("otp"));
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
		
		System.out.println(userId);
		System.out.println(otp);
		UserDao userDao = new UserDao();
		boolean result = userDao.checkOTP(userId,otp);
		if(result == true) {
			System.out.println("IN");
			userDao.updatePassword(password, userId);
			RequestDispatcher rd = request.getRequestDispatcher("StudentDashboardServlet");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
}
