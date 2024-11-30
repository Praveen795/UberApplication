package com.UberApp.Exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
@Getter
public class RuntimeConflictException extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String massage;
	private HttpStatus status;
	
	public RuntimeConflictException(String massage, HttpStatus status) {
		super();
		this.massage = massage;
		this.status = status;
	}
	

	

	
	

}
