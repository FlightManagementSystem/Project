package com.capg.fms.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(String str) {
		super(str);
	}

}
