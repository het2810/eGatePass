package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginServlet")      // mapping with xml servlet
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet Service is ON!");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		ArrayList<UserBean> allUsers = UserDao.listUsers();
//		
		
//		UserBean user = new UserBean();
//		user.setEmail(email);
//		user.setPassword(password);
		
		boolean result = UserDao.checkCredentials(email, password);
		String error = "Invalid Credentials"; 
		if(result == true) {
			int role = UserDao.getRole(email);
			
			int approve = UserDao.getApprove(email);
//			UserBean user = new UserBean();
			UserBean user = UserDao.getDetails(email);
			System.out.println(user.getFirstName());
			System.out.println("enrollement -> " + user.getEnrollmentNumber());
			Cookie cks_i = new Cookie("userId",Integer.toString(user.getUserId()));
			cks_i.setMaxAge(600);
			response.addCookie(cks_i);
			if(role == 4 && approve == 1) {
				Cookie cks_e = new Cookie("enrollment",Integer.toString(user.getEnrollmentNumber()));
				cks_e.setMaxAge(600);
				response.addCookie(cks_e);
				response.sendRedirect("StudentDashboardServlet");
			}
			if(role == 1){
				response.sendRedirect("AdminDashboardServlet");
			}
			if(role == 2) {
				response.sendRedirect("HodDashboardServlet");
			}
			if(role == 3) {
				response.sendRedirect("SecurityDashBoardServlet");
			}
			else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("login4.jsp").include(request, response);
			}
		}
		else {
			request.setAttribute("error", error);
			request.getRequestDispatcher("login4.jsp").include(request, response);
		}
	}
}
