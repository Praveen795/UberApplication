package com.UberApp.Service;

import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.SignUpDto;
import com.UberApp.Dto.UserDto;

public interface AuthService {
	
	String logIn(String username,String password);
	
	UserDto sighUp(SignUpDto signUpDto);
	
	DriverDto onBordingDriver(long user_id);

}
