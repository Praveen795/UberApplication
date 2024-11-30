package com.UberApp.strategies.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UberApp.Dao.DriverRepository;
import com.UberApp.entities.Driver;
import com.UberApp.entities.RideRequest;
import com.UberApp.strategies.DriverMatchingStrategy;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class DriverMatchingNearestDriverStratergy implements DriverMatchingStrategy {
	
	private final DriverRepository driverRepository;
	@Override
	public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
	List<Driver> drivers=driverRepository.findNearestDriver(rideRequest.getPickUpLocation());
		return drivers;
	}

}
