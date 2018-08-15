package com.mipa.admin.web.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mipa.core.data.model.AuthUserModel;

public class UserPrincipal implements UserDetails, Authentication {

	private static final long serialVersionUID = 98L;
	
	private final String userName;
	private AuthUserModel authUserModel = null;
	private final Set<GrantedAuthority> authorities;
	private final boolean accountNonExpired;
	private final boolean accountNonLocked;
	private final boolean credentialsNonExpired;

	public UserPrincipal(final AuthUserModel authUserModel, final Set<GrantedAuthority> authorities) {
		this.userName = authUserModel.getUserName();
		this.authUserModel = authUserModel;
		this.authorities = authorities;
		
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
	}
	
	public Object getCredentials() {
		return null;
	}

	public Object getDetails() {
		return authUserModel;
	}

	public Object getPrincipal() {
		return authUserModel;
	}

	public boolean isAuthenticated() {
		return accountNonExpired && accountNonLocked && credentialsNonExpired;
	}

	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return null;
	}

	public String getUsername() {
		return userName;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return getUsername();
	}
	
	
	
}