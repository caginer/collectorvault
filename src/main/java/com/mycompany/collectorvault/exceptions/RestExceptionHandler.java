package com.mycompany.collectorvault.exceptions;


import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	// Add an exception handler for NotFoundException
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException (NotFoundException exc){
		
		
		//create ErrorResponse
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
				
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException (NoSuchElementException exc){
		
		
		//create ErrorResponse
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											"Esta coleccion no existe",
											System.currentTimeMillis());
				
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	// Add another exception handler to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException (Exception exc){
		
		
		//create ErrorResponse
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
				
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
