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
 * Servlet implementation class ListHodServlet
 */
public class ListHodServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserBean> hod = UserDao.showUsers(2);
		request.setAttribute("hod", hod);
		request.getRequestDispatcher("listHod.jsp").forward(request, response);
	}
}
