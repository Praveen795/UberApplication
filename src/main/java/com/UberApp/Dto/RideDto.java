package com.UberApp.Dto;

import java.time.LocalDateTime;



import com.UberApp.entities.enums.PaymentMethod;
import com.UberApp.entities.enums.RideStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {
	

	private Long rideId;
	
	
	private PointDto pickUpLocation;
	
	private PointDto dropUpLocation;	
	
	private String otp;
	
	private LocalDateTime createdTime;
	
	private RiderDto rider;
	
	private DriverDto driver;
	
	private PaymentMethod paymentMethod;
	
	private RideStatus rideStatus; 
	
	private Double fare;
	
	private LocalDateTime startedAt;
	
	private LocalDateTime endedAt;


}
