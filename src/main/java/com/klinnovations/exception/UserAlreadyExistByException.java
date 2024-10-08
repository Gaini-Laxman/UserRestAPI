package com.klinnovations.exception;

public class UserAlreadyExistByException extends RuntimeException {
	public UserAlreadyExistByException (String message) {
		super(message);
	}
}
