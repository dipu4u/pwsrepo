package com.mipa.core.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 50L;

	public ObjectNotFoundException(final String message) {
		super(message);
	}
	
	public ObjectNotFoundException(final String message, final Throwable th) {
		super(message, th);
	}
	
}
