package com.christianmendez.project.exception;

public class InvalidFormatPasswordException extends RuntimeException{

	private static final long serialVersionUID = 1851387258847836058L;
	
	public InvalidFormatPasswordException() {
		super();
	}

	public InvalidFormatPasswordException(final String message) {
		super(message);
	}
	
}
