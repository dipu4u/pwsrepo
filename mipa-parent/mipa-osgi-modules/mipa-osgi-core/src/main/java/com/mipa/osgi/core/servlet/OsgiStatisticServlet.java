package com.mipa.osgi.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OsgiStatisticServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String statType = request.getParameter("type");
		final String message = "Your selected type is " + (String) statType;
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(message.getBytes());
		outStream.flush();
	}

}