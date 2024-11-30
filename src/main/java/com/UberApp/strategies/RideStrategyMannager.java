package com.UberApp.strategies;

public interface RideStrategyMannager {
	
	public DriverMatchingStrategy driverMatchingStrategy(double rating);
	
	public RideFareCalculationStrategy rideFareCalculationStrategy();

}
