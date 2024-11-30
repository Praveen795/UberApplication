package com.UberApp.ServiceImpl;


import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.UberApp.Dao.RideRequestRepository;
import com.UberApp.Dao.RiderRepository;
import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.RideDto;
import com.UberApp.Dto.RideRequestDto;
import com.UberApp.Dto.RiderDto;
import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Service.DriverService;
import com.UberApp.Service.RideService;
import com.UberApp.Service.RiderService;
import com.UberApp.entities.Ride;
import com.UberApp.entities.RideRequest;
import com.UberApp.entities.Rider;
import com.UberApp.entities.User;
import com.UberApp.entities.enums.RideRequestStatus;
import com.UberApp.entities.enums.RideStatus;
import com.UberApp.strategies.RideStrategyMannager;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Builder
public class RiderServiceImpl implements RiderService {
	
	private final ModelMapper modelMapper;
	private final RideStrategyMannager rideStrategyMannager;
	private final RideRequestRepository rideRequestRepository;
	private final RideService rideService;
	private final RiderRepository riderRepository;
	private final DriverService driverService;
	

	@Override
	@Transactional
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		/*
		 * steps
		 * convert Dto to entity
		 * set status as pending
		 * calculate fare and set it to entity field
		 * save rideRequest in in rideRequest Table inside database
		 * find matching driver
		 * and convert entity to Dto and return it
		 */
		RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		Rider rider = getCurrentRider();
		rideRequest.setRider(rider);
		double fare = rideStrategyMannager.rideFareCalculationStrategy().calculateFare(rideRequest);
		rideRequest.setFare(fare);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

		rideStrategyMannager.driverMatchingStrategy(rider.getRating()).findMatchingDrivers(savedRideRequest);

		return modelMapper.map(savedRideRequest, RideRequestDto.class);
	}

	@Override
	public RideDto cancleRide(long ride_id) {
		//get ride from rideId
		Ride ride= rideService.getRideById(ride_id);
		
		//get current rideRequestRepository 
		Rider rider=getCurrentRider();
		if(rider.getRiderId()!=ride.getRider().getRiderId()) {
			throw new RuntimeException("rider not belongs to to this ride"+rider.getRiderId());
		}
		
		//check ride status is conformed or not
		if (!ride.getRideStatus().equals(RideStatus.CONFORMED)) {
			throw new RuntimeException("ride will unable to cancle now " + ride.getRideStatus());
		}
		driverService.driverAvailability(ride.getDriver(), true);
		
		Ride updateRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);

		return modelMapper.map(updateRide, RideDto.class);


	}

	@Override
	public DriverDto rateDriver(long ride_id, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDto getMyProfile() {
		Rider rider=getCurrentRider();
		return modelMapper.map(rider, RiderDto.class);
	}

	@Override
	public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
		Rider rider=getCurrentRider();
		Page<RideDto> rides = rideService.getAllridesofRider(rider.getRiderId(), pageRequest)
				.map(ride->modelMapper.map(ride, RideDto.class));
		return rides;
	}

	@Override
	public Rider createNewRider(User user) {
		Rider rider=Rider.builder().user(user).rating(0.0).build();
		return rider;
	}

	@Override
	public Rider getCurrentRider() {
		return riderRepository.findById((long) 1)
				.orElseThrow(()->new ResourceNotFoundException("riderId","rider not found", HttpStatus.NOT_FOUND));
	}

}
