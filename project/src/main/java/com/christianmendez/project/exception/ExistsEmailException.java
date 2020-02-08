package com.christianmendez.project.exception;

public class ExistsEmailException extends RuntimeException {

	private static final long serialVersionUID = 2908539943296346814L;

	public ExistsEmailException() {
		super();
	}

	public ExistsEmailException(final String message) {
		super(message);
	}
}
