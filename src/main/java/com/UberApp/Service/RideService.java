package com.UberApp.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.UberApp.Dto.RideDto;

import com.UberApp.entities.Driver;
import com.UberApp.entities.Ride;
import com.UberApp.entities.RideRequest;
import com.UberApp.entities.enums.RideStatus;

public interface RideService {
	
	Ride getRideById(long ride_id);
	
	RideDto createNewRide(RideRequest rideRequest, Driver driver);
	
	Ride updateRideStatus(Ride ride, RideStatus rideStatus);
	
	Page<Ride> getAllridesofRider(long ride_id,PageRequest pageRequest);
	
	Page<Ride> getAllRidesOfDriver(long ride_id,PageRequest pageRequest);

	

}
