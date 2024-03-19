package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ListSecurityServlet
 */
public class ListSecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserBean> security = UserDao.showUsers(3);
		request.setAttribute("security", security);
		request.getRequestDispatcher("listSecurity.jsp").forward(request, response);
	}
}
