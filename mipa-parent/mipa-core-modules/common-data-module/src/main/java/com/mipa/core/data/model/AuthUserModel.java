package com.mipa.core.data.model;

import java.io.Serializable;

import com.mipa.core.data.enums.UserType;

public class AuthUserModel implements Serializable {

	
	private static final long serialVersionUID = 33L;
	
	private final Integer userId;
	private final String userName;
	private final UserType userType;
	
	public AuthUserModel(final Integer userId, final String userName, final UserType userType) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserType getUserType() {
		return userType;
	}
}