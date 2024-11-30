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
public class DriverMatchingHigestRatedStrategy implements DriverMatchingStrategy {
	
	final DriverRepository driverRepository;
	
	@Override
	public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
	
		return driverRepository.findTenNearByTopRatedDriver(rideRequest.getPickUpLocation());
	}

}
