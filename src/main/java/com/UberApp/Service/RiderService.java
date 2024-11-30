package com.UberApp.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.RideDto;
import com.UberApp.Dto.RideRequestDto;
import com.UberApp.Dto.RiderDto;
import com.UberApp.entities.Rider;
import com.UberApp.entities.User;

public interface RiderService {
	
	RideRequestDto requestRide(RideRequestDto rideRequestDto);

	RideDto cancleRide(long ride_id);

	DriverDto rateDriver(long ride_id, Integer rating);

	RiderDto getMyProfile();

	Page<RideDto> getAllMyRides(PageRequest pageRequest);

	Rider createNewRider(User savedUser);
	
	Rider getCurrentRider();

}
