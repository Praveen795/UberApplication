package com.UberApp.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.UberApp.Dao.RideRequestRepository;
import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Service.RideRequestService;
import com.UberApp.entities.RideRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService{
	
	private final RideRequestRepository rideRequestRepository;

	@Override
	public RideRequest getRideRequest(long rideRequestId) {
		//get rideRequest from rideRequestId
		RideRequest rideRequest= rideRequestRepository.findById(rideRequestId)
				.orElseThrow(()-> new ResourceNotFoundException("rideRequestId","rideRequest not found with this id"+rideRequestId,HttpStatus.NOT_FOUND));
		
		return rideRequest;
	}

	@Override
	public RideRequest updateRideRequest(RideRequest rideRequest) {
		rideRequestRepository.findById(rideRequest.getRideRequestId())
				.orElseThrow(() -> new ResourceNotFoundException("rideRequestId", "ResourceNotFoundException not found",
						HttpStatus.NOT_FOUND));
		rideRequestRepository.save(rideRequest);

		return rideRequestRepository.save(rideRequest);
	}

}
