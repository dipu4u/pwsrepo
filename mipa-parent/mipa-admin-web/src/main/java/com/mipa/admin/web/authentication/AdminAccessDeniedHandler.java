package com.mipa.admin.web.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AdminAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger LOG = Logger.getLogger(AdminAccessDeniedHandler.class);
	
	@Value("${admin.accessdenied.url}")
	private String accessDeniedUrl;
	
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException e) throws IOException, ServletException {
		LOG.debug("Access Denied. " + e.getMessage(), e);
		response.sendRedirect(accessDeniedUrl);
	}
}
