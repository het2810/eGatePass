package com.controller;

import java.io.IOException;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.lov.Role;

@WebServlet("/RegistrationServlet")                        // no need to do mapping in web.xml
public class RegistrationServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service Method hit!!!");
		
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String enrollNumber = request.getParameter("en-no");
		int admin =Integer.parseInt(request.getParameter("admin"));
		
		UserBean user = new UserBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(Integer.parseInt(mobile));
		user.setEnrollmentNumber(Integer.parseInt(enrollNumber));
		user.setRole(Role.STUDENT.role);         // enum use is op!!!!!!!!
		
		int result = UserDao.addUser(user);
		if(result == 1) {
			if(admin == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else if(admin == 1) {
				response.sendRedirect("AdminDashboardServlet");
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}
}
