package com.UberApp.Dto;

import java.util.Set;

/*
 * this method for when user signup then this object will return send to the client app.
 * and different layer of app
 * 
 */


import com.UberApp.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String name;
	
	private String email;
	private Set<Role> role;

}
