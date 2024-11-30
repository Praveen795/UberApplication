package com.UberApp.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String massage;
	private HttpStatus httpStatus;
	
	
	
	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ResourceNotFoundException(String resourceName, String massage, HttpStatus httpStatus) {
		super();
		this.resourceName = resourceName;
		this.massage = massage;
		this.httpStatus = httpStatus;
	}



	public String getResourceName() {
		return resourceName;
	}



	public String getMassage() {
		return massage;
	}



	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	





	
	
	
	
	

}
