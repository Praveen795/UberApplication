package com.UberApp.Advices;


import java.time.LocalTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Exception.RuntimeConflictException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeConflictException.class)
	public ResponseEntity<ApiResponse<?>> handleRuntimeConfictException(RuntimeConflictException e){
		ApiError apiError=ApiError.builder()
				.massage(e.getMassage())
				.status(HttpStatus.CONFLICT)
				.build();
		
		return new ResponseEntity<>(new ApiResponse<>( LocalTime.now(), apiError),HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public  ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception){
		ApiError apiError=ApiError.builder()
				.massage(exception.getMassage())
				.status(HttpStatus.NOT_FOUND)
				.build();
	//	ApiResponse<?> response=new ApiResponse<>(new Date(), apiError);
		
		return new ResponseEntity<>(new ApiResponse<>( LocalTime.now(), apiError),HttpStatus.FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<?>> handleMethodNotValidException(MethodArgumentNotValidException exception){
		List<String> error=exception.getBindingResult()
				.getAllErrors()
				.stream()
				.map(errorType->errorType.getDefaultMessage())
				.collect(Collectors.toList());
		
		ApiError apiError=ApiError.builder()
				.massage(exception.getMessage())
				.status(HttpStatus.BAD_REQUEST)
				.subErrors(error)
				.build();
		
		return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse<?>> handleRuntimeException(RuntimeException exception){
		ApiError error=ApiError.builder()
				.massage(exception.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		
		return new ResponseEntity<ApiResponse<?>>(new ApiResponse<>(error),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
	
	
	
	
}
