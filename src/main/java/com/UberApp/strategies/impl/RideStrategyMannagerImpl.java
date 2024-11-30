package com.UberApp.strategies.impl;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.UberApp.strategies.DriverMatchingStrategy;
import com.UberApp.strategies.RideFareCalculationStrategy;
import com.UberApp.strategies.RideStrategyMannager;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class RideStrategyMannagerImpl implements RideStrategyMannager {
	
	private final DriverMatchingHigestRatedStrategy higestRatedStrategy;
	private final DriverMatchingNearestDriverStratergy nearestDriverStratergy;
	private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
	private final RideFareSurgePricingfareCalculationStrategy surgePricingfareCalculationStrategy;

	@Override
	public DriverMatchingStrategy driverMatchingStrategy(double rating) {
		if(rating>=4.5) {
			return higestRatedStrategy;
		}else {
			return nearestDriverStratergy;
		}
		
	}

	@Override
	public RideFareCalculationStrategy rideFareCalculationStrategy() {
		LocalTime surgeStartTime=LocalTime.of(18, 0);
		LocalTime surgeEndTime=LocalTime.of(22, 0);
		LocalTime cuuentTime=LocalTime.now();
		boolean isSurgeTime=cuuentTime.isAfter(surgeStartTime) && cuuentTime.isBefore(surgeEndTime);
		
		if(isSurgeTime) {
			return surgePricingfareCalculationStrategy;
		}else {
			return defaultFareCalculationStrategy;
		}
	}

}
