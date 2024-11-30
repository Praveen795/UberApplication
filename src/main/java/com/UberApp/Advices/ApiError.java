package com.UberApp.Advices;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
	
	private HttpStatus status;
	private String massage;
	private List<String> subErrors;

}
