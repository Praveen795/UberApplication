package com.UberApp.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.RideDto;
import com.UberApp.entities.Driver;


public interface DriverService {
	
	RideDto cancleRide(long ride_id);
	
	RideDto startRide(long ride_id, String otp);
	
	RideDto endRide(long ride_id);
	
	RideDto rateRider(long ride_id, Integer rating);
	
	DriverDto getMyProfile();
	
	Page<RideDto> getAllMyRides(PageRequest pageRequest);
	
	RideDto acceptRide(long rideRequestId);

	Driver currentDriver();
	
	void driverAvailability(Driver driver, boolean avilable);
	

}
