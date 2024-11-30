package com.UberApp.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
	
	private Long driverId;
	private Double rating;
	private UserDto user;
	private boolean available;
	private String vahicleId;
	
	
	

}
