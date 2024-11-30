package com.UberApp.Dto;

import java.time.LocalDateTime;

import com.UberApp.entities.enums.PaymentMethod;
import com.UberApp.entities.enums.RideRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
	
	private Long rideRequestId;
	
	private PointDto pickUpLocation;
	
	private PointDto dropUpLocation;	
	
	private Double fare;
	
	private LocalDateTime requiedTime;

	private RiderDto rider;

	private PaymentMethod paymentMethod;
	
	
	private RideRequestStatus rideRequestStatus; 

}
