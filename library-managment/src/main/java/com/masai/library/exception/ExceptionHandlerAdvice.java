package com.masai.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	/*
	 * @ExceptionHandler(CustomException.class) public
	 * ResponseEntity<CustomException> handleCustomException(CustomException ex) {
	 * return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); }
	 */
}
