package com.UberApp.strategies;

import java.util.List;

import com.UberApp.entities.Driver;
import com.UberApp.entities.RideRequest;

public interface DriverMatchingStrategy {
	
	List<Driver> findMatchingDrivers(RideRequest rideRequest);

}
