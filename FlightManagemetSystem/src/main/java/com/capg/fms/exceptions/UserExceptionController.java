package com.capg.fms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<String> handleException(Exception ex){
		if(ex instanceof UserNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity("Invalid User Id ", status);
		}
		else {
			return null;
		}
	}

}
