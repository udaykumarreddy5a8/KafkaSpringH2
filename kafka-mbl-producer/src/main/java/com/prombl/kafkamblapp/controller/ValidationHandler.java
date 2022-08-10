package com.prombl.kafkamblapp.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	private final Logger log 
	= LoggerFactory.getLogger(ValidationHandler.class);
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		long startTime = System.currentTimeMillis();
		log.info("#ValidationHandler#handleMethodArgumentNotValid#I# {}",startTime);
		Map<String, Object> msgMap = new LinkedHashMap<>();
		Map<String, String> errors = new HashMap<>();
		try {
			
			ex.getBindingResult().getAllErrors().forEach(error ->{
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			msgMap.put("status", "failed");
			msgMap.put("message", "Message Send failed");
			msgMap.put("errorType", "InvalidRequestException");
			msgMap.put("errors",errors);
		}catch (Exception e) {
			msgMap.put("status","failed");
			msgMap.put("message","Message Send Failed");
			msgMap.put("errorType",e.getMessage());
			log.info("#ValidationHandler#handleMethodArgumentNotValid#E# {}",(System.currentTimeMillis()-startTime));
		}
		log.info("#ValidationHandler#handleMethodArgumentNotValid#O# {}",(System.currentTimeMillis()-startTime));
		return new ResponseEntity<>(msgMap, HttpStatus.BAD_REQUEST);
	}

}
