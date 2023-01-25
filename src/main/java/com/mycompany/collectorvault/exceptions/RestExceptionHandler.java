package com.mycompany.collectorvault.exceptions;



import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	// Add an exception handler for NotFoundException
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNotFoundException (NotFoundException exc){
		
		
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
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNotVaultException (VaultException exc){
		
		
		//create ErrorResponse
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMensaje(),
											System.currentTimeMillis());
				
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException (Exception exc){
		
		
		//create ErrorResponse
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.INTERNAL_SERVER_ERROR.value(),
											exc.getMessage(),
											System.currentTimeMillis());
				
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	Map<String, String> errors = new HashMap<>();	
	ex.getBindingResult().getAllErrors().forEach((error) -> {
		String campName = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		
		errors.put(campName, message);
	});
		
				
	
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); 
		
	}
}
