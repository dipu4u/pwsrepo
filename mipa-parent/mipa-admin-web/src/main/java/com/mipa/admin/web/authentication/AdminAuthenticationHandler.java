package com.mipa.admin.web.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AdminAuthenticationHandler 
		implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

	private static final Logger LOG = Logger.getLogger(AdminAuthenticationHandler.class);

	@Value("${admin.default.page.url}")
	private String homePageUrl;
	
	@Value("${admin.login.failure.url}")
	private String loginFailureUrl;
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		LOG.debug("Login successful " + authentication.getName());
		response.sendRedirect(homePageUrl);
	}
	
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ae)
			throws IOException, ServletException {
		LOG.debug("Admin Authentication Failure.", ae);
		response.sendRedirect(loginFailureUrl);
	}
	
}