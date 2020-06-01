package com.anz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(NoAccountExistException.class)
	public ResponseEntity<ErrorMessage> accountExceptionHandler(NoAccountExistException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(AccountExistException.class)
	public ResponseEntity<ErrorMessage> accountExceptionHandler(AccountExistException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(NoTransactionExistException.class)
	public ResponseEntity<ErrorMessage> transactionExceptionHandler(NoTransactionExistException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	

}
