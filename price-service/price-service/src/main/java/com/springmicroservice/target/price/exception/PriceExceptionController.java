package com.springmicroservice.target.price.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class PriceExceptionController {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<PriceExceptionEntity> handleException(NoSuchElementException ex) {
		return new ResponseEntity<PriceExceptionEntity>(new PriceExceptionEntity(HttpStatus.NOT_FOUND, ErrorConstants.PRODUCT_NOT_FOUND, ex),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<PriceExceptionEntity> handleException(NullPointerException ex) {
		return new ResponseEntity<PriceExceptionEntity>(new PriceExceptionEntity(HttpStatus.GATEWAY_TIMEOUT, ErrorConstants.INTERNAL_SERVER_ERROR, ex),
				HttpStatus.GATEWAY_TIMEOUT);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<PriceExceptionEntity> handleException(IllegalArgumentException ex) {
		return new ResponseEntity<PriceExceptionEntity>(new PriceExceptionEntity(HttpStatus.BAD_REQUEST, ErrorConstants.MISSING_FIELDS, ex),
				HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<PriceExceptionEntity> resourceNotFound(PriceNotFoundException ex) {
		return new ResponseEntity<PriceExceptionEntity>(new PriceExceptionEntity(HttpStatus.NOT_FOUND, ErrorConstants.PRODUCT_NOT_FOUND, ex),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<PriceExceptionEntity> resourceNotFound(MethodArgumentNotValidException ex) {
		BindingResult errors = ex.getBindingResult();

		PriceExceptionEntity entity = new PriceExceptionEntity(HttpStatus.BAD_REQUEST);
		entity.setErrorMessage(ErrorConstants.INVALID_REQUEST);
		List<String> errorsList = new ArrayList<>();

		if (errors.hasFieldErrors()) {
			errors.getFieldErrors().forEach(fe -> {
				String fieldError = fe.getDefaultMessage();
				errorsList.add(fieldError);
			});

		}
		entity.setValidationErrors(errorsList);
		return new ResponseEntity<PriceExceptionEntity>(entity, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<PriceExceptionEntity> dbError(SQLException ex) {
		return new ResponseEntity<PriceExceptionEntity>(new PriceExceptionEntity(HttpStatus.BAD_REQUEST, ErrorConstants.DB_ERROR, ex),
				HttpStatus.BAD_REQUEST);
	}

}
