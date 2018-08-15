package com.mipa.admin.web.model;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {
	
	private static final long serialVersionUID = 99L;

	private final String role;
	
	public UserAuthority(final String role) {
		this.role = role;
	}
	
	public String getAuthority() {
		return this.role;
	}

}