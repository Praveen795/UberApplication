package com.UberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.UberApp.Service.DistanceService;
import com.UberApp.entities.RideRequest;
import com.UberApp.strategies.RideFareCalculationStrategy;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RideFareSurgePricingfareCalculationStrategy implements RideFareCalculationStrategy {

	private final DistanceService distanceService;
	private static final double SURGE_FARE=2;
	
	@Override
	public Double calculateFare(RideRequest rideRequest) {

		Double calculatedDistance = distanceService.calculateDistance(rideRequest.getPickUpLocation(), 
				rideRequest.getDropUpLocation());
		
		
		return calculatedDistance*DistanceService.DISTANCE_FARE*SURGE_FARE;
		
		
	}

}
