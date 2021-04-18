package com.springmicroservice.target.price.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Exception model class to be used in ExceptionController to process the error messages when exception occurs
 * 
 */
public class PriceExceptionEntity {

	private HttpStatus status;
	private String errorMessage;
	private List<String> validationErrors;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "CST")
	private Date timestamp;

	PriceExceptionEntity(){
		timestamp = new Date();
		System.out.println("timestamp:"+timestamp);
	}

	PriceExceptionEntity(HttpStatus status) {
		this();
		this.status = status;
	}
	PriceExceptionEntity(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.errorMessage = ex.getMessage();
	}
	PriceExceptionEntity(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.errorMessage = message;
		System.out.println("timestamp:"+timestamp);
	}

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	


}

