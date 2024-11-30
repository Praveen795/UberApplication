package com.UberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.UberApp.Service.DistanceService;
import com.UberApp.entities.RideRequest;
import com.UberApp.strategies.RideFareCalculationStrategy;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy{

	private final DistanceService distanceService;
	
	@Override
	public Double calculateFare(RideRequest rideRequest) {
		
		Double calculatedDistance = distanceService.calculateDistance(rideRequest.getPickUpLocation(), 
				rideRequest.getDropUpLocation());
		
		
		return calculatedDistance*DistanceService.DISTANCE_FARE;
	}

}
