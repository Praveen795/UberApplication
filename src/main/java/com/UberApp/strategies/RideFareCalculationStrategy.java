package com.UberApp.strategies;

import com.UberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {
	
	Double calculateFare(RideRequest rideRequest);

}
