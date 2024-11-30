package com.UberApp.Service;

import com.UberApp.entities.RideRequest;

public interface RideRequestService {
	
	public RideRequest getRideRequest(long rideRequestId);

	public RideRequest updateRideRequest(RideRequest rideRequest);

}
