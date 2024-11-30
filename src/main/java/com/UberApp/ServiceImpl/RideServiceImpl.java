package com.UberApp.ServiceImpl;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.UberApp.Dao.RideRepository;
import com.UberApp.Dto.RideDto;
import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Service.RideRequestService;
import com.UberApp.Service.RideService;
import com.UberApp.entities.Driver;
import com.UberApp.entities.Ride;
import com.UberApp.entities.RideRequest;
import com.UberApp.entities.enums.RideRequestStatus;
import com.UberApp.entities.enums.RideStatus;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {
	
	private final RideRepository rideRepository;
	private final ModelMapper modelMapper;
	private final RideRequestService rideRequestService;
	

	@Override
	public Ride getRideById(long ride_id) {
		Ride ride = rideRepository.findById(ride_id)
		.orElseThrow(()-> new ResourceNotFoundException("rideId","id not found",HttpStatus.NOT_FOUND));
		return ride;
	}
	
	
	@Override
	public RideDto createNewRide(RideRequest rideRequest, Driver driver) {
		rideRequest.setRideRequestStatus(RideRequestStatus.CONFORMED);
		
		Ride ride=modelMapper.map(rideRequest, Ride.class);
		ride.setRideStatus(RideStatus.CONFORMED);
		ride.setDriver(driver);
		ride.setOtp(generateValidOTP());
		ride.setRideId(null);
		Ride savedRide = rideRepository.save(ride);
		rideRequestService.updateRideRequest(rideRequest);
		
		return modelMapper.map(savedRide, RideDto.class);
	}


	@Override
	public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
		ride.setRideStatus(rideStatus);
		Ride savedRide = rideRepository.save(ride);
		return savedRide;

	}

	@Override
	public Page<Ride> getAllridesofRider(long riderId, PageRequest pageRequest) {
		return rideRepository.getAllRideByriderId(riderId);
		
	}

	@Override
	public Page<Ride> getAllRidesOfDriver(long driverId, PageRequest pageRequest) {
		Page<Ride> allRideBydriverId = rideRepository.getAllRideBydriverId(driverId);
		return allRideBydriverId;
	}
	
 
/*
 * internal methods 
 */
	private String generateValidOTP() {
		Random random=new Random();
		int otpInt=random.nextInt(10000);
		return String.format("%04d", otpInt);
	}
	

}
