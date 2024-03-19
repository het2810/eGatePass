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


@WebServlet("/ListRequestServlet")
public class ListRequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<RequestBean> requests = new ArrayList<RequestBean>(); 
		requests=RequestDao.getAllRequests();
		int particular = 0;
		
		int security = Integer.parseInt(request.getParameter("security"));
		
		request.setAttribute("requests", requests);
		request.setAttribute("particular",particular);
		request.setAttribute("security",security);

		RequestDispatcher rd = request.getRequestDispatcher("listRequest.jsp");
		rd.forward(request, response);
	}
}
