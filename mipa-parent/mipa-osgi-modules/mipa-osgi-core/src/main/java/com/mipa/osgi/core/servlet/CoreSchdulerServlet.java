package com.mipa.osgi.core.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mipa.osgi.core.service.impl.JobSchedulerServiceImpl;

public class CoreSchdulerServlet extends HttpServlet {

	private static final long serialVersionUID = 19L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String statType = request.getParameter("type");
		final String message = "Your selected type is " + (String) statType;
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(message.getBytes());
		outStream.flush();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String providerIdStr = request.getParameter("providerid");
		if(Objects.isNull(providerIdStr) || providerIdStr.trim().length() == 0) {
			response.setStatus(400);			
		} else {
			JobSchedulerServiceImpl serviceImpl = new JobSchedulerServiceImpl();
			boolean status = serviceImpl.scheduleJob(Integer.parseInt(providerIdStr));
			if(status) response.setStatus(201);
			else response.setStatus(409);
		}
	}

}