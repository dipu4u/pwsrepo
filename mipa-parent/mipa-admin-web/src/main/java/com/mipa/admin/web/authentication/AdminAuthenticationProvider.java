package com.mipa.admin.web.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.mipa.admin.web.constant.AppConstants;
import com.mipa.admin.web.model.UserAuthority;
import com.mipa.admin.web.model.UserPrincipal;
import com.mipa.core.data.model.AuthUserModel;


public class AdminAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger LOG = Logger.getLogger(AdminAuthenticationProvider.class);
	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		final String userName = authentication.getName();
		LOG.debug("Perform authentication for " + userName);
		AuthUserModel authUserModel = AppConstants.APP_USERS.get(userName);
		
		if(Objects.isNull(authUserModel) || !isPasswordMatched(authentication.getCredentials().toString())) {
			throw new BadCredentialsException("Failed Attempt for " + userName);
		}
		return getUser(authUserModel);
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private UserPrincipal getUser(final AuthUserModel authUserModel) {
		Set<GrantedAuthority> roleSet = Collections.singleton((GrantedAuthority)
						new UserAuthority(AppConstants.ROLE_PREFIX + authUserModel.getUserType().name()));		
		return new UserPrincipal(authUserModel, roleSet);
	}
	
	private boolean isPasswordMatched(final String password) {
		boolean matched = false;
		try {
			MessageDigest digest = MessageDigest.getInstance(AppConstants.HASH_ALGORITHM);
			digest.update(password.getBytes());
			final String hashPassword = DatatypeConverter.printHexBinary(digest.digest()).toUpperCase();
			matched = AppConstants.HASH_PASSWORD.equals(hashPassword);
		} catch(NoSuchAlgorithmException nsae) {
			LOG.error(nsae);
		}
		return matched;
	}
	
}