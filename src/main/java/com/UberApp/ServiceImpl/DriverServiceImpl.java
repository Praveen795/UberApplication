package com.UberApp.ServiceImpl;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UberApp.Dao.DriverRepository;
import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.RideDto;
import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Service.DriverService;
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
public class DriverServiceImpl implements DriverService {

	private final RideRequestService rideRequestService;
	private final DriverRepository driverRepository;
	private final RideService rideService;
	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public RideDto acceptRide(long rideRequestId) {
		// step 1. get rideReuest
		RideRequest savedRideRequest = rideRequestService.getRideRequest(rideRequestId);

		// check rideReuestStatus is pending or conformed if pending do further process
		if (!savedRideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
			throw new RuntimeException(
					"rideRrquest canout accept ride is already " + savedRideRequest.getRideRequestStatus());
		}

		// get current driver
		Driver currentDriver = currentDriver();

		// check driver is available or not
		if (!currentDriver.isAvailable()) {
			throw new RuntimeException("Driver is unavailable");
		}

		// create new ride using ride service
		RideDto newRide = rideService.createNewRide(savedRideRequest, currentDriver);
		return newRide;
	}

	@Override
	@Transactional
	public RideDto startRide(long ride_id, String otp) {
		// get ride using ride id
		Ride ride = rideService.getRideById(ride_id);

		// check ride rideStatus if it is conformed throw exception
		if (!ride.getRideStatus().equals(RideStatus.CONFORMED)) {
			throw new RuntimeException("ride is not conformed" + ride.getRideStatus());
		}

		// get current driver and check current driver match with ride driver or else
		// throw exception
		Driver driver = currentDriver();
		if (!driver.equals(ride.getDriver())) {
			throw new RuntimeException("driver not matched with ride " + ride.getDriver());

		}

		// check otp match with ride otp or else throw exception
		if (!otp.equals(ride.getOtp())) {
			throw new RuntimeException("OTP does not match with ride otp " + otp);

		}

		// set ride status as ongoing, make driver unavailable,and set startedTime and
		// save ride
		ride.setStartedAt(LocalDateTime.now());
		Ride updateRideStatus = rideService.updateRideStatus(ride, RideStatus.ONGOING);
		driver.setAvailable(false);
		driverRepository.save(driver);

		return modelMapper.map(updateRideStatus, RideDto.class);
	}

	
	@Override
	public RideDto endRide(long ride_id) {
		
		return null;
	}
	
	@Override
	@Transactional
	public RideDto cancleRide(long ride_id) {
		Ride ride = rideService.getRideById(ride_id);

		if (!ride.getRideStatus().equals(RideStatus.CONFORMED)) {
			throw new RuntimeException("ride will unable to cancle now " + ride.getRideStatus());
		}

		Driver driver = currentDriver();
		if (!driver.equals(ride.getDriver())) {
			throw new RuntimeException("driver not matched with ride " + ride.getDriver());

		}

		driver.setAvailable(true);
		driverRepository.save(driver);
		Ride updateRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);

		return modelMapper.map(updateRide, RideDto.class);
	}
	
	@Override
	public DriverDto getMyProfile() {
		Driver driver = currentDriver();
		return modelMapper.map(driver, DriverDto.class);
	}


	@Override
	public RideDto rateRider(long ride_id, Integer rating) {
		
		return null;
	}

	

	@Override
	public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
		Driver driver = currentDriver();
		Page<RideDto> rides = rideService.getAllRidesOfDriver(driver.getDriverId(), pageRequest)
				.map(ride -> modelMapper.map(ride, RideDto.class));

		return rides;
	}

	@Override
	public Driver currentDriver() {
		long id = 2;
		Driver driver = driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("driverId",
				"driver not found with this " + 1, HttpStatus.NOT_FOUND));
		return driver;

	}

	@Override
	public void driverAvailability(Driver driver, boolean avilable) {
		driver.setAvailable(true);
		driverRepository.save(driver);
		
	}

}
