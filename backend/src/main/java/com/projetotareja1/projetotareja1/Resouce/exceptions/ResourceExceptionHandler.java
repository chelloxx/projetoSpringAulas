package com.projetotareja1.projetotareja1.Resouce.exceptions;

import java.time.Instant;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetotareja1.projetotareja1.services.exceptions.DatabaseException;
import com.projetotareja1.projetotareja1.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;




@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request)
	{
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError erro = new StandarError();
		
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Resource not found");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
		
		
		
		
	}
	

	@ExceptionHandler(DatabaseException.class)
	
	public ResponseEntity<StandarError> Database(ResourceNotFoundException e, HttpServletRequest request)
	{
		
		HttpStatus status= HttpStatus.BAD_REQUEST;
		StandarError erro = new StandarError();
		
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Resource not found");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
		
		
		
		
	}
	
	

	
	
	
	
}
