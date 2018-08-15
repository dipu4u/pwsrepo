package com.mipa.core.exception;

public class InvalidInputException extends RuntimeException {

	
	private static final long serialVersionUID = 51L;

	public InvalidInputException(final String message) {
		super(message);
	}
	
	public InvalidInputException(final Throwable th) {
		super(th);
	}
	
}
