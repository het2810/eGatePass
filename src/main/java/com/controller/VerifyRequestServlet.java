package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RequestDao;

@WebServlet("/VerifyRequest")
public class VerifyRequestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached!");
		Integer reqId = Integer.parseInt(request.getParameter("requestId"));
		int accept = Integer.parseInt(request.getParameter("accept"));
		int waiting = Integer.parseInt(request.getParameter("waiting"));
		int reject = Integer.parseInt(request.getParameter("reject"));
		int hod = Integer.parseInt(request.getParameter("hod"));
		int security = Integer.parseInt(request.getParameter("security"));
		RequestDao.setOutTime(reqId);
		response.sendRedirect("ListRequestForHodServlet?accept="+accept+"&reject="+reject+"&waiting="+waiting+"&hod="+hod+"&security="+security);
	}
}