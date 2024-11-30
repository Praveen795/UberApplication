package com.UberApp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UberApp.Dto.SignUpDto;
import com.UberApp.Dto.UserDto;
import com.UberApp.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/signUp")
	public UserDto signUp(@RequestBody SignUpDto signUpDto) {
		UserDto sighUpResponse = authService.sighUp(signUpDto);
		return sighUpResponse;
		
	}

}
