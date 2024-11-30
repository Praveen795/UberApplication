package com.UberApp.Advices;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	
	private  LocalTime timeStamp;
	private T data;
	private ApiError apiError;
	
	public ApiResponse(T data) {
		super();
		this.data = data;
		this.timeStamp=timeStamp.now();
	}

	public ApiResponse(ApiError apiError) {
		super();
		timeStamp=timeStamp.now();
		this.apiError=apiError;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(LocalTime timeStamp, ApiError apiError) {
		super();
		this.timeStamp=timeStamp;
		this.apiError = apiError;
	}
	
	
	
	
	
	
	
	
	

}
